package com.giuseppe.demo.service;







import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.stereotype.Service;

import com.giuseppe.demo.model.Transaction;
import com.giuseppe.demo.model.User;
import com.giuseppe.demo.repository.TransactionRepo;
import com.giuseppe.demo.repository.UserRepo;


@Service
public class UserService {
	@Autowired
	UserRepo userRepo;
	@Autowired
	TransactionRepo transactionRepo;


	public User authenticateUser(User user) {
		return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}



	public boolean depositMoney(Integer userId, Transaction transaction) {
		User userFromDB = userRepo.findById(userId).orElse(null);
		transaction.setType("Deposit");
		transactionRepo.save(transaction);
		userFromDB.setBalance(userFromDB.getBalance() + transaction.getAmount());
		transaction.setUser(userFromDB);
		userRepo.save(userFromDB);
		return true;
	}


	public boolean withdrawMoney(Integer userId, Transaction transaction) {
		User userFromDB = userRepo.findById(userId).orElse(null);
		transaction.setType("Withdraw");
		transactionRepo.save(transaction);
		if (userFromDB.getBalance() >= transaction.getAmount()) {
			userFromDB.setBalance(userFromDB.getBalance() - transaction.getAmount());
			transaction.setUser(userFromDB);
			userRepo.save(userFromDB);
			return true;
		} else {
			return false;
		}
	}


	public boolean transferMoney(Integer userIdFunder, String usernameRecipient, Transaction transaction) {
		User userFunderFromDb = userRepo.findById(userIdFunder).orElse(null);
		User userRecipientFromDb = userRepo.findByUsername(usernameRecipient);

		if (userRecipientFromDb == null || userFunderFromDb.getBalance() < transaction.getAmount()) {
			return false;
		}
		transaction.setType("Transfer");
		transactionRepo.save(transaction);
		userFunderFromDb.setBalance(userFunderFromDb.getBalance() - transaction.getAmount());
		userRecipientFromDb.setBalance(userRecipientFromDb.getBalance() + transaction.getAmount());
		transaction.setUser(userFunderFromDb);
		transaction.setRecipient(userRecipientFromDb);
		userRepo.save(userFunderFromDb);
		userRepo.save(userRecipientFromDb);

		return true;
	}

}
