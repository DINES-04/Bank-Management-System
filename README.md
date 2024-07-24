# Bank Management System

This is a Java-based Bank Management System project that includes various functionalities like ATM operations, balance enquiry, deposits, withdrawals, mini statements, and more. The project uses external libraries to enhance its functionality.

## Table of Contents

1. [Project Structure](#project-structure)
2. [Features](#features)
3. [External Libraries](#external-libraries)
4. [Setup Instructions](#setup-instructions)
5. [Usage](#usage)
6. [Screenshots](#screenshots)
7. [Contributing](#contributing)
8. [License](#license)
9. [Acknowledgements](#acknowledgements)

## Project Structure

The project consists of the following Java files:

- `ATM.java`: Handles ATM operations.
- `BalanceEnquiry.java`: Allows users to check their account balance.
- `Deposit.java`: Manages deposit transactions.
- `FastCash.java`: Enables quick cash withdrawals.
- `FinalForm.java` and `FinalForm2.java`: Final forms for various transactions.
- `MainClass.java`: The main entry point of the application.
- `MiniStatement.java`: Provides mini statements of transactions.
- `PinChange.java`: Allows users to change their PIN.
- `Signup.java`, `Signup2.java`, and `Signup3.java`: Handle user sign-up processes.
- `Withdraw.java`: Manages withdrawal transactions.

## Features

- **ATM Operations**: Perform basic ATM functions such as balance enquiry, deposit, and withdrawal.
- **Balance Enquiry**: Check account balances easily.
- **Deposits**: Deposit money into your account.
- **Fast Cash**: Quick cash withdrawal options.
- **Mini Statements**: View recent transactions.
- **PIN Change**: Change your account PIN securely.
- **User Sign-Up**: Register new users with a multi-step sign-up process.

## External Libraries

The project requires the following external libraries:

- `jcalendar-1.4.jar`: For date selection and calendar functionality.
- `jgoodies-looks-2.4.1.jar`: For improved UI look and feel.
- `junit-4.6.jar`: For unit testing.
- `mysql-connector-j-8.0.31.jar`: For MySQL database connectivity.

## Setup Instructions

1. **Clone the Repository**:

    ```sh
    git clone https://github.com/yourusername/bank-management-system.git
    cd bank-management-system
    ```

2. **Add External Libraries**:
    - Download the external libraries listed above.
    - Add the JAR files to your project's build path.

3. **Configure MySQL Database**:
    - Create a MySQL database and import the provided SQL script.
    - Update the database connection details in your Java files.

4. **Compile and Run the Project**:
    - Use an IDE like Eclipse or IntelliJ IDEA to compile and run the project.
    - Ensure all external libraries are included in your project build path.

## Usage

1. **Start the Application**: Run `MainClass.java` to start the Bank Management System.
2. **ATM Operations**: Use the application interface to perform various banking operations.
3. **User Registration**: New users can sign up using the multi-step sign-up process.

## Screenshots

Include screenshots of the application in action, if possible, to give users a visual understanding of the system.

![Bank Management System](path/to/your/bank_image.jpg)

## Contributing

If you wish to contribute to this project, please create a pull request with a detailed description of your changes.

## License

This project is licensed under the MIT License. See the LICENSE file for more information.

## Acknowledgements

Thanks to the developers of the external libraries used in this project.
