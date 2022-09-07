package main.actions;

import java.util.function.BiPredicate;

public interface ChecksFunds {
	BiPredicate<Double, Double> hasEnoughFunds = (balance, amount) -> balance >= amount;
	
}
