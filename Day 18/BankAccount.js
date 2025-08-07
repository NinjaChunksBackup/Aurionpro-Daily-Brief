function BankAccount(accountHolder, balance) {
  this.accountHolder = accountHolder;
  this.balance = balance;

  this.deposit = function(amount) {
    if (amount > 0) {
      this.balance += amount;
      console.log(`₹${amount} deposited. New balance: ₹${this.balance}`);
    } else {
      console.log("Invalid deposit amount.");
    }
  };

  this.withdraw = function(amount) {
    if (amount > 0 && amount <= this.balance) {
      this.balance -= amount;
      console.log(`₹${amount} withdrawn. Remaining balance: ₹${this.balance}`);
    } else {
      console.log("Insufficient funds or invalid amount.");
    }
  };

  this.getBalance = function() {
    console.log(`${this.accountHolder}'s balance: ₹${this.balance}`);
  };
}

const account1 = new BankAccount("Mayuri", 5000);
const account2 = new BankAccount("sakshi", 3000);


account1.deposit(2000);        
account1.withdraw(1000);    
account1.getBalance();     

account2.withdraw(5000);      
account2.getBalance();   


// const account1 = {
//   accountHolder: "Mayuri",
//   balance: 5000,
//   deposit: function(amount) {
//     if (amount > 0) {
//       this.balance += amount;
//       console.log(`₹${amount} deposited. New balance: ₹${this.balance}`);
//     } else {
//       console.log("Invalid deposit amount.");
//     }
//   },
//   withdraw: function(amount) {
//     if (amount > 0 && amount <= this.balance) {
//       this.balance -= amount;
//       console.log(`₹${amount} withdrawn. Remaining balance: ₹${this.balance}`);
//     } else {
//       console.log("Insufficient funds or invalid amount.");
//     }
//   },
//   getBalance: function() {
//     console.log(`${this.accountHolder}'s balance: ₹${this.balance}`);
//   }
// };

// const account2 = {
//   accountHolder: "Rohan",
//   balance: 3000,
//   deposit: function(amount) {
//     if (amount > 0) {
//       this.balance += amount;
//       console.log(`₹${amount} deposited. New balance: ₹${this.balance}`);
//     } else {
//       console.log("Invalid deposit amount.");
//     }
//   },
//   withdraw: function(amount) {
//     if (amount > 0 && amount <= this.balance) {
//       this.balance -= amount;
//       console.log(`₹${amount} withdrawn. Remaining balance: ₹${this.balance}`);
//     } else {
//       console.log("Insufficient funds or invalid amount.");
//     }
//   },
//   getBalance: function() {
//     console.log(`${this.accountHolder}'s balance: ₹${this.balance}`);
//   }
// };

// // Use
// account1.deposit(2000);  // ₹2000 deposited. New balance: ₹7000
// account2.withdraw(500);  // ₹500 withdrawn. Remaining balance: ₹2500

