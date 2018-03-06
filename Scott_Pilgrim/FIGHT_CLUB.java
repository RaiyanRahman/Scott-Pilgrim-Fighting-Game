/***    FIGHT_CLUB.java
	This is a game where you are in control of a character and are tasked with the objective of defeating as many enemies
	as you can before your health runs out. The program will then display your score which is dependant on the number of
	enemies you defeated.
	@Authors: Raiyan Rahman, Afeef Mehta.
	@Date: January 12th, 2017.
	@Version: 6.5
	***/
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.*;
public class FIGHT_CLUB extends JLabel implements ActionListener, KeyListener
{
    // This creates a Timer for the whole program allowing repaint and KeyListener
    Timer tmr = new Timer (5, this);
    // Variables
    int playerX = 275, playerY = 600, playerVX = 0, playerVY = 0, playerHealth = 6500, enemyX = 500, enemyY = 1000, enemyVX = 0, enemyVY = 0, enemyAttack = 10, enemyHealth = 30, hitLeft = playerX - 11, hitRight = playerX + 11, score = 0, menucounter = 400;
    boolean endGame = false;    // Endgame Conditions
    Image Title = new ImageIcon ("Images/Title.png").getImage ();   // Title Image
    // Menu Icons
    Image PlayOn = new ImageIcon ("Images/Play_On.png").getImage ();
    Image ControlsOn = new ImageIcon ("Images/Controls_On.png").getImage ();
    Image ExitOn = new ImageIcon ("Images/Exit_On.png").getImage ();
    Image PlayOff = new ImageIcon ("Images/Play_Off.png").getImage ();
    Image ControlsOff = new ImageIcon ("Images/Controls_Off.png").getImage ();
    Image ExitOff = new ImageIcon ("Images/Exit_Off.png").getImage ();
    Image ControlScreen = new ImageIcon ("Images/Controls.png").getImage ();    // Displays the controls of the game
    Image backdrop = new ImageIcon ("Images/Background3.png").getImage ();  // The bacground
    // Character Movements
    Image moveRight = new ImageIcon ("Images/scott_dash.gif").getImage ();
    Image moveLeft = new ImageIcon ("Images/scott_dash_reverse.gif").getImage ();
    Image Idle = new ImageIcon ("Images/scott_idle.gif").getImage ();
    Image ReversedIdle = new ImageIcon ("Images/scott_idle_reversed.gif").getImage ();
    Image Punch = new ImageIcon ("Images/scott_punch.gif").getImage ();
    Image ReversedPunch = new ImageIcon ("Images/scott_punch_reversed.gif").getImage ();
    Image GutPunch = new ImageIcon ("Images/scott_gutpunch.gif").getImage ();
    Image ReversedGutPunch = new ImageIcon ("Images/scott_gutpunch_reversed.gif").getImage ();
    Image Upper = new ImageIcon ("Images/scott_upper.gif").getImage ();
    Image ReversedUpper = new ImageIcon ("Images/scott_upper_reversed.gif").getImage ();
    Image Guitar = new ImageIcon ("Images/scott_guitar.gif").getImage ();
    Image ReversedGuitar = new ImageIcon ("Images/scott_guitar_reversed.gif").getImage ();
    // Enemy Movements
    Image EnemyMR = new ImageIcon ("Images/Enemy_dash.gif").getImage ();
    Image EnemyML = new ImageIcon ("Images/Enemy_dash_reversed.gif").getImage ();
    Image EnemyPunch = new ImageIcon ("Images/Enemy_hit.gif").getImage ();
    Image EnemyReversedPunch = new ImageIcon ("Images/Enemy_hit_reversed.gif").getImage ();
    // Endscreen
    Image endScreen = new ImageIcon ("Images/score.png").getImage ();   // Endscreen Score Displayer
    // Score Digits
    Image scoreOne = new ImageIcon ("Images/numberOne.png").getImage ();
    Image scoreTwo = new ImageIcon ("Images/numberTwo.png").getImage ();
    Image scoreThree = new ImageIcon ("Images/numberThree.png").getImage ();
    Image scoreFour = new ImageIcon ("Images/numberFour.png").getImage ();
    Image scoreFive = new ImageIcon ("Images/numberFive.png").getImage ();
    Image scoreSix = new ImageIcon ("Images/numberSix.png").getImage ();
    Image scoreSeven = new ImageIcon ("Images/numberSeven.png").getImage ();
    Image scoreEight = new ImageIcon ("Images/numberEight.png").getImage ();
    Image scoreNine = new ImageIcon ("Images/numberNine.png").getImage ();
    Image scoreZero = new ImageIcon ("Images/numberZero.png").getImage ();
    // Health Bar Images
    Image healthRed = new ImageIcon ("Images/HealthRedBar.png").getImage ();
    Image healthGreen = new ImageIcon ("Images/HealthGreenBar.png").getImage ();
    Image healthCaption = new ImageIcon ("Images/HealthCaption.png").getImage ();
    // Current Image Varuables
    Image currentPlayerImage = Idle;
    Image currentEnemyImage = Idle;
    Image MenuImage1 = PlayOn;
    Image MenuImage2 = ControlsOff;
    Image MenuImage3 = ExitOff;
    //
    public FIGHT_CLUB ()
    {
	tmr.start ();
	addKeyListener (this);
	setFocusable (true);
	setFocusTraversalKeysEnabled (false);
    }


    // This starts the method of actions that are able to be executed
    public void actionPerformed (ActionEvent e)
    {
	// Invisible Boundaries
	if (playerX < 135)
	{
	    playerVX = 0;
	    playerX = 135;
	}
	if (playerX > 775)
	{
	    playerVX = 0;
	    playerX = 775;
	}
	if (playerY < 500)
	{
	    playerVY = 0;
	    playerY = 500;
	}
	if (playerY > 750)
	{
	    playerVY = 0;
	    playerY = 750;
	}

	// Settings adjusting player position
	playerX = playerX + playerVX;
	playerY = playerY + playerVY;
	hitLeft = playerX - 31;
	hitRight = playerX + 31;
	repaint ();
    }

    //This method contains the keys that are pressable and their actions
    public void keyPressed (KeyEvent e)
    {
	int c = e.getKeyCode ();

	if (!endGame)
	{

	    // Player moves LEFT
	    if (c == KeyEvent.VK_LEFT)
	    {
		currentPlayerImage = moveLeft;
		playerVX = -4;
		playerVY = 0;
	    }

	    // Player moves UP
	    if (c == KeyEvent.VK_UP)
	    {
		if (menucounter == 0)
		{
		    currentPlayerImage = moveRight;
		    playerVX = 0;
		    playerVY = -4;
		}
		else if (menucounter < 400)
		{
		    menucounter = 400;
		}
		else if (menucounter == 500)
		{
		}
		else
		{
		    menucounter = menucounter - 300;
		}
	    }

	    // Player moves RIGHT
	    if (c == KeyEvent.VK_RIGHT)
	    {
		currentPlayerImage = moveRight;
		playerVX = 4;
		playerVY = 0;
	    }

	    // Player moves DOWN
	    if (c == KeyEvent.VK_DOWN)
	    {
		if (menucounter == 0)
		{
		    currentPlayerImage = moveRight;
		    playerVX = 0;
		    playerVY = 4;
		}
		else if (menucounter > 1000)
		{
		    menucounter = 1000;
		}
		else if (menucounter == 500)
		{
		}
		else
		{
		    menucounter = menucounter + 300;
		}
	    }

	    // Player PUNCHES
	    if (c == KeyEvent.VK_Z)
	    {
		if (currentPlayerImage == ReversedIdle)
		{
		    currentPlayerImage = ReversedPunch;
		    if (enemyX == hitLeft)
		    {
			enemyHealth = enemyHealth - 5;
		    }
		}
		if (currentPlayerImage == Idle)
		{
		    currentPlayerImage = Punch;
		    if (enemyX == hitRight)
		    {
			enemyHealth = enemyHealth - 5;
		    }
		}
	    }

	    // Player GUT PUNCHES
	    if (c == KeyEvent.VK_X)
	    {
		if (currentPlayerImage == ReversedIdle)
		{
		    currentPlayerImage = ReversedGutPunch;
		    if (enemyX == hitLeft)
		    {
			enemyHealth = enemyHealth - 15;
		    }
		}
		if (currentPlayerImage == Idle)
		{
		    currentPlayerImage = GutPunch;
		    if (enemyX == hitRight)
		    {
			enemyHealth = enemyHealth - 15;
		    }
		}
	    }

	    // Player UPPERCUTS
	    if (c == KeyEvent.VK_C)
	    {
		if (currentPlayerImage == ReversedIdle)
		{
		    currentPlayerImage = ReversedUpper;
		    if (enemyX == hitLeft)
		    {
			enemyHealth = enemyHealth - 30;
		    }
		}
		if (currentPlayerImage == Idle)
		{
		    currentPlayerImage = Upper;
		    if (enemyX == hitRight)
		    {
			enemyHealth = enemyHealth - 30;
		    }
		}
	    }

	    /* Player GUITAR SOLOS
	    if (c == KeyEvent.VK_V)
	    {
		if (currentPlayerImage == ReversedIdle)
		{
		    currentPlayerImage = ReversedGuitar;
		}
		if (currentPlayerImage == Idle)
		{
		    currentPlayerImage = Guitar;
		}
	    }*/
	    if (c == KeyEvent.VK_ENTER)
	    {
		if (menucounter == 400)
		{
		    menucounter = 0;
		}
		if (menucounter == 500)
		{
		    menucounter = 700;
		}
		else if (menucounter == 700)
		{
		    menucounter = 500;
		}
		else if (menucounter == 1000)
		{
		    System.exit (1);
		}
	    }

	}
    }


    public void keyTyped (KeyEvent e)
    {
    }


    public void keyReleased (KeyEvent e)
    {
	// Players speed is 0
	playerVX = 0;
	playerVY = 0;

	// Determining where player faces when idle
	if (currentPlayerImage == moveLeft || currentPlayerImage == ReversedPunch || currentPlayerImage == ReversedGutPunch || currentPlayerImage == ReversedUpper || currentPlayerImage == ReversedGuitar)
	{
	    currentPlayerImage = ReversedIdle;
	}
	else
	{
	    currentPlayerImage = Idle;
	}
    }


    public void paintComponent (Graphics g)
    {
	super.paintComponent (g);

	// Drawing background
	g.drawImage (backdrop, 0, 0, getWidth (), getHeight (), null);

	if (menucounter == 400 || menucounter == 100)
	{
	    MenuImage1 = PlayOn;
	    MenuImage2 = ControlsOff;
	    MenuImage3 = ExitOff;
	    g.drawImage (Title, 285, 25, 700, 300, null);
	    g.drawImage (MenuImage1, 475, 325, 250, 125, null);
	    g.drawImage (MenuImage2, 450, 425, 300, 100, null);
	    g.drawImage (MenuImage3, 500, 510, 175, 95, null);
	}
	else if (menucounter == 700)
	{
	    MenuImage1 = PlayOff;
	    MenuImage2 = ControlsOn;
	    MenuImage3 = ExitOff;
	    g.drawImage (Title, 285, 25, 700, 300, null);
	    g.drawImage (MenuImage1, 485, 330, 200, 100, null);
	    g.drawImage (MenuImage2, 425, 400, 350, 125, null);
	    g.drawImage (MenuImage3, 500, 510, 175, 95, null);
	}
	else if (menucounter == 500)
	{
	    g.drawImage (ControlScreen, 200, 150, 900, 600, null);
	}
	else if (menucounter == 1000 || menucounter == 1300)
	{
	    MenuImage1 = PlayOff;
	    MenuImage2 = ControlsOff;
	    MenuImage3 = ExitOn;
	    g.drawImage (Title, 285, 25, 700, 300, null);
	    g.drawImage (MenuImage1, 485, 330, 200, 100, null);
	    g.drawImage (MenuImage2, 450, 425, 300, 100, null);
	    g.drawImage (MenuImage3, 485, 500, 225, 120, null);
	}
	else if (menucounter == 0)
	{

	    // Health Bar
	    if (!endGame && playerHealth > 0)
	    {
		g.drawImage (healthCaption, 230, 0, 150, 75, null);
		g.drawImage (healthRed, 45, 70, 510, 60, null);
		g.drawImage (healthGreen, 50, 75, (playerHealth / 13), 50, null);
	    }

	    // Drawing the player
	    if (currentPlayerImage == Upper || currentPlayerImage == ReversedUpper)
	    {
		int tempx = playerX - 35, tempy = playerY - 60;
		g.drawImage (currentPlayerImage, tempx, tempy, 180, 200, null);
	    }
	    else
	    {
		g.drawImage (currentPlayerImage, playerX, playerY, 110, 120, null);
	    }

	    // Spawning and directing enemy to fight
	    if (enemyHealth > 0)
	    {

		if (enemyX == hitLeft && enemyY == playerY)
		{
		    enemyX = hitLeft;
		    currentEnemyImage = EnemyPunch;
		    g.drawImage (currentEnemyImage, enemyX, enemyY, 150, 160, null);
		    playerHealth = playerHealth - enemyAttack;
		    if (playerHealth <= 0)
		    {
			endGame = true;
		    }
		}
		else if (enemyX == hitRight && enemyY == playerY)
		{
		    enemyX = hitRight;
		    currentEnemyImage = EnemyReversedPunch;
		    g.drawImage (currentEnemyImage, enemyX, enemyY, 150, 160, null);
		    playerHealth = playerHealth - enemyAttack;
		    if (playerHealth <= 0)
		    {
			endGame = true;
		    }
		}
		else
		{
		    if (hitLeft > enemyX)
		    {
			enemyVX = 1;
			currentEnemyImage = EnemyMR;
		    }
		    if (hitRight < enemyX)
		    {
			enemyVX = -1;
			currentEnemyImage = EnemyML;
		    }
		    if (playerY > enemyY)
		    {
			enemyVY = 1;
		    }
		    if (playerY < enemyY)
		    {
			enemyVY = -1;
		    }

		    enemyX = enemyX + enemyVX;
		    enemyY = enemyY + enemyVY;
		    g.drawImage (currentEnemyImage, enemyX, enemyY, 110, 120, null);
		}

	    }
	    else
	    {
		enemyHealth = 30;   // Sets the enemy health
		enemyAttack = enemyAttack + 10; // Increases the difficulty
		// Sets the spawn point
		enemyX = 500;
		enemyY = 1000;
		// Increases the players score
		score = score + 1;
	    }
	}

	// Score screen
	if (endGame)
	{
	    g.drawImage (endScreen, 375, 175, 500, 250, null);  // Displays the Score Icon at the endscreen
	    //int tempScore = score;
	    //int length = String.valueOf(score).length();
	    //for (int i = 1; i <= length; i++)
	    //{
	    //while (score > 0)
	    //{
	    if (score == 1)
	    {
		g.drawImage (scoreOne, 535, 425, 150, 300, null);   // Displays 1
	    }
	    if (score == 2)
	    {
		g.drawImage (scoreTwo, 535, 425, 150, 300, null);   // Displays 2
	    }
	    if (score == 3)
	    {
		g.drawImage (scoreThree, 535, 425, 150, 300, null); // Displays 3
	    }
	    if (score == 4)
	    {
		g.drawImage (scoreFour, 535, 425, 150, 300, null);  // Displays 4
	    }
	    if (score == 5)
	    {
		g.drawImage (scoreFive, 535, 425, 150, 300, null);  // Displays 5
	    }
	    if (score == 6)
	    {
		g.drawImage (scoreSix, 535, 425, 150, 300, null);   // Displays 6
	    }
	    if (score == 7)
	    {
		g.drawImage (scoreSeven, 535, 425, 150, 300, null); // Displays 7
	    }
	    if (score == 8)
	    {
		g.drawImage (scoreEight, 535, 425, 150, 300, null); // Displays 8
	    }
	    if (score == 9)
	    {
		g.drawImage (scoreNine, 535, 425, 150, 300, null);  // Displays 9
	    }
	    if (score == 0)
	    {
		g.drawImage (scoreZero, 535, 425, 150, 300, null);  // Displays 0
	    }
	    //score = score/10;
	    //}
	    //score = tempScore;
	    //}
	}

	if (endGame)
	{
	    enemyX = 100000;
	    enemyY = 100000;
	    g.drawImage (ReversedGuitar, 950, 400, 150, 160, null);
	}
    }

    // The main method
    public static void main (String[] args)
    {
	FIGHT_CLUB t = new FIGHT_CLUB ();   // This invokes the methohd that initiates the whole game
	JFrame frame = new JFrame ("Fight Club");   // This creaetes a JFrame where the game is displayed
	frame.setVisible (true);    // Sets the frame to visible
	frame.getPreferredSize ();  // This gets the preferred size fro the JFrame
	frame.setExtendedState (Frame.MAXIMIZED_BOTH);  // This sets the fram to maximum where it covers the whole screen
	frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);  // This sets the action that will occur when the x button is pressed
	frame.getContentPane ().add (t);    // This adds the image content to the JFrame
	t.requestFocusInWindow ();  // This focuses the keys pressed so that they only apply to KeyListener
	//BGMusic (); // This invokes the BackGround Music
    }

    // This is the method that starts the BGM
    public static void BGMusic ()
    {
	AudioPlayer MGP = AudioPlayer.player;   // This creates the Java Music Player
	AudioStream BGM;    // This variable creates a Music Stream
	AudioData MD;   // This variable creates Sound Data
	ContinuousAudioDataStream loop = null;  // This sets up the Music to Loop
	try // This will import the BGM file
	{
	    BGM = new AudioStream (new FileInputStream ("Sounds/POL-night-warriors-short.wav"));    // This imports the sound file
	    MD = BGM.getData ();    // This saves the sound file to the Sound Data
	    loop = new ContinuousAudioDataStream (MD);  // This assigns the sound file data to the loop
	}
	catch (IOException error)   // This will be displayed if the file is not found
	{
	    System.out.print ("The file can not be found"); // Error message
	}

	MGP.start (loop);   // This begins the Music Loop
    }
}
