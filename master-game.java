import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class TextAdventure {
	// Initialize player name and level
	static int playerLevel;
	static String playerName;
	// Level 0 Variables
	static String entersCave;
	static double playerHealth;
	// Level 1 Variables
	static int rocksNum;
	static double damage; 
	static double newDamage;
	// Level 2 Variables
    static boolean hasSword;
    static String playerChoice;
    // Level 3 variables
    static int maxStrengths;
    static int playersStrength;
    static int DragonsHP;
    static String loseMessage;
    static String winMessage;
    static String playerTraits;
    static int gold;
    
    public TextAdventure(){
    	// Initialize player name and level
    	playerLevel = 0;
    	playerName = "";
    	// Level 0 Variables
    	entersCave = "";
    	playerHealth = 0;
    	// Level 1 Variables
    	rocksNum = 0;
    	damage = 0; 
    	newDamage = 0;
    	// Level 2 Variables
        hasSword = false;
        playerChoice = "";
        // Level 3 variables
        maxStrengths = 0;
        playersStrength = 0;
        DragonsHP = 0;
        loseMessage = "";
        winMessage = "";
        playerTraits = "";
        gold = 0;
    }

 public static void main(String[] args) throws InterruptedException {
  // Initialize variables from Java's library
  Scanner userInput = new Scanner(System.in);
  Random generator = new Random();
  playerHealth = 50.0;
  rocksNum = generator.nextInt(8) + 2; // Generates random integer from 2 to 5
  damage = generator.nextDouble() * 8 + 3; // Generates random decimal between 10 and 3
  hasSword = false;
  maxStrengths = 30 + 1;
  playersStrength = generator.nextInt(maxStrengths) + 10;
  DragonsHP = generator.nextInt(maxStrengths) + 10;
  loseMessage = "Oh no! The dragon defeated you!";
  winMessage = "You slained the dragon! HOORAY!";
  playerTraits = "";
  // Level 4 variables
  // Level 5 variables
  // Level 6 variables
  gold = generator.nextInt(41) + 10; // finds random number between 10 and 50
  // starts game
  printText("What will your character's name be?");
  playerName = userInput.nextLine();
if (playerLevel == 0) { // Level 0: 
   printText("Welcome " + playerName + "!");
   printText("Before you is a large cave mouth and darkness. Dare you enter the Cave of Wonders? \n (Type true, false, yes, or no)");
   entersCave = userInput.nextLine();
   if (entersCave.equals("true") || entersCave.equals("yes")) {
    printText("Good job. You bravely enter the cave. You are about to have the adventure of your life!");
    TimeUnit.SECONDS.sleep(2);
    playerLevel++;
    printText("You have passed the first test. Your bravery has rewarded you. Congratulations " + playerName + ", you are now level " + playerLevel + ".");
   } else if (entersCave.equals("false") || entersCave.equals("no")) {
    printText("I see you are not up to the challenge. You walk away from an experience of a lifetime and to the safety of your warm, cozy bed. :|");
    printText(playerName + " runs home and goes to sleep.");
    System.exit(0);
   }
  }
if(playerLevel == 1) { // Level 1: Trip Wire and Rock Slide
	printText("Venturing into the dark cave, you feel something press against your leg...");
	printText("It's a trap! Suddenly you are being bombarded by " + rocksNum + " rocks from above");
	damage = damage * rocksNum;
	newDamage = Math.round(damage * 10.0);
	newDamage /= 10.0;
	playerHealth-=newDamage;
	playerHealth = Math.round(playerHealth * 10.0);
	playerHealth /= 10.0;
	TimeUnit.SECONDS.sleep(5);
	playerHealth = (playerHealth < 0.0) ? 0.0 : playerHealth;
	printText("You have " + playerHealth + " health remaining.");
	if(playerHealth <= 0.0) {
		printText("The rocks suffocate you. GAME OVER! Your score is " + findScore());
		System.exit(0);
	}
	else {
		playerLevel++;
	}
}
if(playerLevel == 2) { // Level 2: Chest and Magic Sword
	TimeUnit.SECONDS.sleep(2);
	printText("Level up! You are now level " + playerLevel);
	// The player finds a chest
    printText("You pick yourself up from the cave floor and brush a cloud of dust from your clothes.\nThe cave narrows as you press on until you manage to squeeze through an opening into a large natural cavern.");
    printText("Before you is a treasure chest.");
    printText("a Open the chest.");
    printText("b Ignore the chest. Obvious trap");
    playerChoice = userInput.nextLine();
    if(playerChoice.equals("a")) {
    	printText("You slowly and fearfully open the chest to reveal a magic sword! Your strength has increased by 20. \n Anticipating a trap, you grab it an run as fast as your legs can carry you.");
    	hasSword = true;
    	playersStrength+=20;
    	playerTraits = "bravery, luck, curiousity, and reflexes";
    }
    else if(playerChoice.equals("b")) {
    	printText("I guess you'll never know what was inside the chest.");
    	hasSword = false;
    	playerTraits = "bravery and luck";
    }
    else {
    	printText("It looks like I did not understand that! Next time, type either a or b.");
    	System.exit(0);
    }
    playerLevel++;
}
if(playerLevel == 3) { // Level 3: Slaying the dragon
	  TimeUnit.SECONDS.sleep(1);
	  printText("Level up! You are now level " + playerLevel);
	  printText("Your " + playerTraits + " have brought you this far."); 
	  printText("However, you only have " + playerHealth + " health left and " + playersStrength + " strength.");
	  printText("You leave the cavern with the chest and continue your journey");
	  TimeUnit.SECONDS.sleep(3);
      printText("Up ahead the air grows warm and wet. You hear snoring.");
      printText("Peeking around a corner you see a monstrous shape! A dragon sleeps in the room ahead.");
      printText("You swallow hard and must make a decision. The choice is yours; Will you fight or flight?");
      playerChoice = userInput.nextLine();
      if(playerChoice.equals("fight")){
    	  printText("You are one courageous fellow. You charge the dragon.");
      }
      else if(playerChoice.equals("flight")) {
    	  printText("I guess this is too much for you. You flee from the room and get out of the Cave just in the nick of time.");
    	  printText("Your score is " + findScore());
    	  System.exit(0);
      }
	  printText("Player's Strength: " + playersStrength + "\nDragons HP: " + DragonsHP + "\nPlayer has the sword: " + hasSword);
	  if (playersStrength == DragonsHP) {
	   if (hasSword) {
	    printText("You're not strong enough to defeat the dragon alone \nHowever, you remember your magic sword...");
	   } else {
	    printText("You can't defeat the dragon with your bare hands. \nYou try fighting, but you gradually lose stamina and get very tired.");
	    playersStrength-=10;
	    playerHealth-=(playerHealth/2);
	   }
	  }
	  if (playersStrength > DragonsHP) {
	   printText(winMessage);
	   playerLevel++;
	  } else if (playersStrength < DragonsHP) {
	   printText(loseMessage);
	   printText("Finally, the dragon towers over you and swallows you hole. \n GAME OVER! Your score is " + findScore());
	   System.exit(0);
	  }
	}
if(playerLevel == 4) { // Level 4: Riddle
	printText("Well done! Slaying the dragon was the hardest part, so now you go downhill.");
	printText("Answer the following riddle to pass:");
	printText("If you feed me, I grow and live, but if you give me water, I die. What am I?");
	String usersAnswer = userInput.nextLine();
	if(usersAnswer.equalsIgnoreCase("fire")) {
		printText("Correct! Level up!");
		playerLevel++;
	}
	else {
		printText("Incorrect. GAME OVER. Your score is " + findScore());
	}
}
if(playerLevel == 5) { // Level 5: Gold
	printText("Congratulations, " + playerName + ", you have beat the game. Now for your prize!  You open the door to find a vault of " + gold + " gold pieces!!");
	printText("Now for the final decision: True or False: you will grab all the gold and escape?");
	boolean grabsAll = userInput.nextBoolean();
	if(grabsAll) {
		printText("No! It is a trap! You lose all of your gold. You score is " + findScore());
		
	}
	else {
		printText("Magnificent! You passed the final test! You have a score of " + findScore());
	}
}
userInput.close();
 }
public static void printText(String message) {
	System.out.println(message);
}
public static int findScore() {
		int swordValue = (hasSword) ? 10 : -10;
	return (int)(playerLevel * (playerHealth + playersStrength) + swordValue + gold);
 }
}
