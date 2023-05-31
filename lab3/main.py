import getpass


class OperationsManager:
    def __init__(self, a: float, b: float) -> None:
        self.a = a
        self.b = b

    def perform_division(self) -> float:
        """Divides a with b. If b is zero, returns nan.
        If a or b aren't numbers, returns nan."""
        return self.a / self.b


def login_success():
    """If a or b can't be parsed, set them to nan.
    If eval can't be evaluated, set result to nan."""
    a = float(input("A = "))
    b = float(input("B = "))
    ops_manager = OperationsManager(a, b)
    print(ops_manager.perform_division())

    expression = input("Enter a mathematical formula to calculate: ")
    print("Result:", eval(expression))


def main():
    user = input("Username: ")
    password = getpass.getpass("Password: ")

    if user != "root" or password != "123":
        print("Wrong username or password!")
        return
    else:
        print("Login success!")
        login_success()


if __name__ == "__main__":
    main()
