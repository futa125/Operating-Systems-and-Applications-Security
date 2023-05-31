import unittest
import math
from io import StringIO
from unittest.mock import patch

from main import OperationsManager, login_success, main


class OperationsManagerTest(unittest.TestCase):
    def setUp(self):
        self.ops_manager = OperationsManager(0, 0)

    def test_perform_division(self):
        self.ops_manager.a = 10
        self.ops_manager.b = 2

        result = self.ops_manager.perform_division()

        self.assertEqual(result, 5)

    def test_perform_division_with_negative(self):
        self.ops_manager.a = 10
        self.ops_manager.b = -5

        result = self.ops_manager.perform_division()

        self.assertAlmostEqual(result, -2)

    def test_perform_division_with_zero(self):
        self.ops_manager.a = 10
        self.ops_manager.b = 0

        result = self.ops_manager.perform_division()

        self.assertTrue(math.isnan(result))

    def test_perform_division_with_decimals(self):
        self.ops_manager.a = 10
        self.ops_manager.b = 3

        result = self.ops_manager.perform_division()

        self.assertAlmostEqual(result, 10/3)

    def test_perform_division_with_strings(self):
        self.ops_manager.a = "10"
        self.ops_manager.b = "5"

        result = self.ops_manager.perform_division()

        self.assertTrue(math.isnan(result))

    def test_perform_division_with_nan(self):
        self.ops_manager.a = 10
        self.ops_manager.b = float("nan")

        result = self.ops_manager.perform_division()

        self.assertTrue(math.isnan(result))

        self.ops_manager.a = float("nan")
        self.ops_manager.b = 10

        result = self.ops_manager.perform_division()

        self.assertTrue(math.isnan(result))

    def test_perform_division_with_inf(self):
        self.ops_manager.a = 10
        self.ops_manager.b = float("inf")

        result = self.ops_manager.perform_division()

        self.assertEqual(result, 0)

        self.ops_manager.a = 10
        self.ops_manager.b = float("-inf")

        result = self.ops_manager.perform_division()

        self.assertEqual(result, 0)


class LoginSuccessTest(unittest.TestCase):
    @patch("builtins.input", side_effect=["5", "2", "1 + 2"])
    def test_login_success(self, _):
        expected_output = "2.5\nResult: 3\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            login_success()
            self.assertEqual(fake_output.getvalue(), expected_output)

    @patch("builtins.input", side_effect=["ABC", "DEF", "1 + 2"])
    def test_login_success_invalid_input(self, _):
        expected_output = "nan\nResult: 3\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            login_success()
            self.assertEqual(fake_output.getvalue(), expected_output)

    @patch("builtins.input", side_effect=["5", "0", "1 + 2"])
    def test_login_success_divide_by_zero(self, _):
        expected_output = "nan\nResult: 3\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            login_success()
            self.assertEqual(fake_output.getvalue(), expected_output)

    @patch("builtins.input", side_effect=["5", "2", "1 / 0"])
    def test_login_success_eval_divide_by_zero(self, _):
        expected_output = "2.5\nResult: nan\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            login_success()
            self.assertEqual(fake_output.getvalue(), expected_output)

    @patch("builtins.input", side_effect=["5", "2", "ABC"])
    def test_login_success_eval_invalid_expression(self, _):
        expected_output = "2.5\nResult: nan\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            login_success()
            self.assertEqual(fake_output.getvalue(), expected_output)


class MainTest(unittest.TestCase):
    @patch("builtins.input")
    @patch("getpass.getpass")
    def test_valid_login_credentials(self, mock_getpass, mock_input):
        mock_input.side_effect = ["root", "5", "2", "5 + 2"]
        mock_getpass.return_value = "123"
        expected_output = "Login success!\n2.5\nResult: 7\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            main()
            self.assertEqual(fake_output.getvalue(), expected_output)

    @patch("builtins.input")
    @patch("getpass.getpass")
    def test_invalid_username(self, mock_getpass, mock_input):
        mock_input.side_effect = ["user"]
        mock_getpass.return_value = "123"
        expected_output = "Wrong username or password!\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            main()
            self.assertEqual(fake_output.getvalue(), expected_output)

    @patch("builtins.input")
    @patch("getpass.getpass")
    def test_invalid_password(self, mock_getpass, mock_input):
        mock_input.side_effect = ["root"]
        mock_getpass.return_value = "1234"
        expected_output = "Wrong username or password!\n"
        with patch("sys.stdout", new=StringIO()) as fake_output:
            main()
            self.assertEqual(fake_output.getvalue(), expected_output)


if __name__ == "__main__":
    unittest.main()
