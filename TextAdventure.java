import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class TextAdventure {
	static Random generator = new Random();
	static Scanner userInput = new Scanner(System. in );
	static boolean hasSword = false;
	static int maxStrengths = 30 + 1;
	static int playersStrength = generator.nextInt(maxStrengths) + 10;
	static int DragonsHP = generator.nextInt(maxStrengths) + 10;
	static String playerName;
	static int gold = generator.nextInt(41) + 10; // finds random number between 10 and 50
	static int playerLevel = 0;
	static double playerHealth = 50.0;
	static int rocksNum = generator.nextInt(8) + 2; // Generates random integer from 2 to 5
	static double damage = generator.nextDouble() * 8 + 3; // Generates random decimal between 10 and 3
	static Score score = new Score(hasSword, playerLevel, playerHealth, playersStrength, gold);	

	public static void main(String[] args) throws InterruptedException {
		// Initialize variables from Java's library
		String loseMessage = "Oh no! The dragon defeated you!";
		String winMessage = "You slained the dragon! HOORAY!";
		String playerTraits = "";
		String playerChoice;
		String entersCave;
		// Starts Game
		printText("What will your character's name be?");
		playerName = userInput.nextLine();
		if (playerLevel == 0) { // Stage 0: 
			printText("Welcome " + playerName + "!");
			printText("Before you is a large cave mouth and darkness. Dare you enter the Cave of Wonders? \n (Type true, false, yes, or no)");
			entersCave = userInput.nextLine();
			if (entersCave.equalsIgnoreCase("true") || entersCave.equalsIgnoreCase("yes")) {
				printText("Good job. You bravely enter the cave. You are about to have the adventure of your life!");
				waitTime(2);
				playerLevel++;
			} else if (entersCave.equalsIgnoreCase("false") || entersCave.equalsIgnoreCase("no")) {
				printText("I see you are not up to the challenge. You walk away from an experience of a lifetime and to the safety of your warm, cozy bed. :|");
				printText(playerName + " runs home and goes to sleep.");
				System.exit(0);
			}
		}
		if (playerLevel == 1) { // Stage 1: Trip Wire and Rock Slide
			printText("You have passed the first test. Your bravery has rewarded you. Congratulations " + playerName + ", you are now level " + playerLevel + ".");
			waitTime(2);
			printText("Venturing into the dark cave, you feel something press against your leg...");
			waitTime(1);
			printText("It's a trap! Suddenly you are being bombarded by " + rocksNum + " rocks from above");
			damage = damage * rocksNum; // The damagePerRock times the NumberOfRocks equals the total rock number
			damage = Math.round(damage * 10.0); // Round (totalDamage * 10)
			damage /= 10.0; // Divide rounded number by 10 to get a quotient that is the total damage to the nearest tenth
			playerHealth -= damage; // Player loses this amount of health
			playerHealth = Math.round(playerHealth * 10.0); // Round (health * 10)
			playerHealth /= 10.0; // Divide rounded number by 10 to get a quotient that is the new health to the nearest tenth
			waitTime(5);
			playerHealth = (playerHealth < 0.0) ? 0.0 : playerHealth;
			printText("You have " + playerHealth + " health remaining.");
			if (playerHealth <= 0.0) {
				printText("The rocks suffocate you. GAME OVER! Your score is " + score.find());
				System.exit(0);
			}
			else {
				playerLevel++;
			}
		}
		if (playerLevel == 2) { // Stage 2: Chest and Magic Sword
			waitTime(2);
			printText("Level up! You are now level " + playerLevel);
			waitTime(1);
			// The player finds a chest
			printText("You pick yourself up from the cave floor and brush a cloud of dust from your clothes.\nThe cave narrows as you press on until you manage to squeeze through an opening into a large natural cavern.");
			waitTime(3);
			printText("Before you is a treasure chest.");
			printText("a Open the chest.");
			printText("b Ignore the chest. Obvious trap");
			playerChoice = userInput.nextLine();
			if (playerChoice.equalsIgnoreCase("a")) {
				printText("You slowly and fearfully open the chest to reveal a magic sword! Your strength has increased by 20. \n Anticipating a trap, you grab it an run as fast as your legs can carry you.");
				hasSword = true;
				playersStrength += 20;
				playerTraits = "bravery, luck, curiousity, and reflexes";
				playerLevel++;
			}
			else if (playerChoice.equalsIgnoreCase("b")) {
				printText("I guess you'll never know what was inside the chest.");
				hasSword = false;
				playerTraits = "bravery and luck";
			}
			else {
				printText("It looks like I did not understand that! Next time, type either a or b.");
				System.exit(0);
			}

		}
		if (playerLevel == 3) { // Stage 3: Slaying the dragon
			waitTime(1);
			printText("Level up! You are now level " + playerLevel);
			printText("Your " + playerTraits + " have brought you this far.");
			printText("However, you only have " + playerHealth + " health left and " + playersStrength + " strength.");
			printText("You leave the cavern with the chest and continue your journey");
			waitTime(3);
			printText("Up ahead the air grows warm and wet. You hear snoring.");
			printText("Peeking around a corner you see a monstrous shape! A dragon sleeps in the room ahead.");
			printText("You swallow hard and must make a decision. The choice is yours; Will you fight or flight?");
			playerChoice = userInput.nextLine();
			if (playerChoice.equals("fight")) {
				printText("You are one courageous fellow. You charge the dragon.");
			}
			else if (playerChoice.equals("flight")) {
				printText("As you run away to hide in the safety of your warm bed, the dragon yawns and returns to its slumber.");
				printText("Your score is " + score.find());
				System.exit(0);
			}
			printText("Player's Strength: " + playersStrength + "\nDragons HP: " + DragonsHP + "\nPlayer has the sword: " + hasSword);
			if (playersStrength == DragonsHP) {
				if (hasSword) {
					printText("You're not strong enough to defeat the dragon alone \nHowever, you remember your magic sword...");
				} else {
					printText("You can't defeat the dragon with your bare hands. \nYou try fighting, but you gradually lose stamina and get very tired.");
					playersStrength -= 10;
					playerHealth /= 2;
				}
			}
			if (playersStrength > DragonsHP) {
				printText(winMessage);
				playerLevel++;
			} else if (playersStrength < DragonsHP) {
				printText(loseMessage);
				printText("Finally, the dragon towers over you and swallows you hole. \n GAME OVER! Your score is " + score.find());
				System.exit(0);
			}
		}
		if (playerLevel == 4) { // Stage 4: Riddle
			printText("Well done! Slaying the dragon was the hardest part, so now you go downhill.");
			printText("Answer the following riddle to pass:");
			printText("If you feed me, I grow and live, but if you give me water, I die. What am I?");
			String usersAnswer = userInput.nextLine();
			if (usersAnswer.equalsIgnoreCase("fire")) {
				printText("Correct! Level up!");
				playerLevel++;
			}
			else {
				printText("Incorrect. GAME OVER. Your score is " + score.find());
			}
		}
		if (playerLevel == 5) { // Stage 5: Gold
			level5();
		}
		userInput.close();
	}

	public static void printText(String message) {
		System.out.println(message);
	}
	public static void waitTime(int seconds) throws InterruptedException {
		TimeUnit.SECONDS.sleep(seconds);
	}

	public static void level5() {
		printText("Congratulations, " + playerName + ", you have beat the game. Now for your prize!  You open the door to find a vault of " + gold + " gold pieces!!");
		printText("Now for the final decision: True or False: you will grab all the gold and escape?");
		boolean grabsAll = userInput.nextBoolean();
		if (grabsAll) {
			printText("No! It is a trap! You lose all of your gold. You score is " + score.find());
			System.exit(0);
		}
		else {
			printText("Magnificent! You passed the final test! You have a score of " + score.find());
		}
	}
}