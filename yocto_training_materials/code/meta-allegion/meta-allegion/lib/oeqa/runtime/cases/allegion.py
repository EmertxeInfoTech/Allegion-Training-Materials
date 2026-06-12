# Allegion runtime tests, run via: bitbake <image> -c testimage
# See QA Gates study guide

from oeqa.runtime.case import OERuntimeTestCase
from oeqa.core.decorator.depends import OETestDepends


class AllegionTest(OERuntimeTestCase):

    def test_systemd_is_pid1(self):
        status, output = self.target.run('ps -p 1 -o comm=')
        self.assertEqual(status, 0, msg="ps failed")
        self.assertIn('systemd', output,
                      msg="PID 1 is not systemd: %s" % output)

    def test_mydaemon_running(self):
        status, output = self.target.run('systemctl is-active mydaemon')
        self.assertEqual(output.strip(), 'active',
                         msg="mydaemon not active: %s" % output)

    def test_no_failed_units(self):
        status, output = self.target.run('systemctl --failed --no-legend')
        self.assertEqual(output.strip(), '',
                         msg="Failed units present: %s" % output)

    def test_hello_runs(self):
        status, output = self.target.run('hello')
        self.assertEqual(status, 0, msg="hello failed to run")
        self.assertIn('Hello', output)
