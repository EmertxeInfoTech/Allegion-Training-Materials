# trainergw_led.py (D3S9)
# A custom testimage runtime test case.
# Install to: meta-trainerdemo/lib/oeqa/runtime/cases/trainergw_led.py
# Enable with:
#   IMAGE_CLASSES += "testimage"
#   TEST_SUITES = "ping ssh trainergw_led"
# Run with:
#   bitbake trainergw-image -c testimage
#
# testimage boots the image under QEMU and runs these test methods against it
# over SSH. Each test uses self.target.run() to execute a command on the target.

from oeqa.runtime.case import OERuntimeTestCase
from oeqa.core.decorator.depends import OETestDepends


class TrainerGWLedTest(OERuntimeTestCase):
    """Runtime checks for the TrainerGW reference image."""

    @OETestDepends(['ssh.SSHTest.test_ssh'])
    def test_gw_info_present(self):
        """gw-info must be installed and runnable."""
        status, output = self.target.run('which gw-info')
        self.assertEqual(status, 0,
                         msg='gw-info not found on the image: %s' % output)

    @OETestDepends(['ssh.SSHTest.test_ssh'])
    def test_gw_info_runs(self):
        """gw-info must run and report a kernel version."""
        status, output = self.target.run('gw-info')
        self.assertEqual(status, 0,
                         msg='gw-info failed to run: %s' % output)
        self.assertIn('Kernel version', output,
                      msg='gw-info output missing kernel line: %s' % output)

    @OETestDepends(['ssh.SSHTest.test_ssh'])
    def test_hello_trainergw(self):
        """hello-trainergw must print its greeting."""
        status, output = self.target.run('hello-trainergw')
        self.assertEqual(status, 0, msg='hello-trainergw failed: %s' % output)
        self.assertIn('Hello from TrainerGW', output,
                      msg='unexpected greeting: %s' % output)

    @OETestDepends(['ssh.SSHTest.test_ssh'])
    def test_ssh_root_login_disabled(self):
        """Security check: root SSH login must be disabled in the image."""
        status, output = self.target.run(
            "grep -E '^PermitRootLogin' /etc/ssh/sshd_config")
        # If the directive is present it must be 'no'.
        if status == 0:
            self.assertIn('no', output.lower(),
                          msg='PermitRootLogin is not set to no: %s' % output)
