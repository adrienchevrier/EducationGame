package gfx;

import java.awt.image.BufferedImage;

/**
 * Created by adrien on 04/05/16.
 * 2Dgame project class
 *
 * Class contains and extracts all images from an array
 */
public class Assets {
    private static final int width = 64,height = 64;
    private static final int screenWidth = 1366,screenHeight = 700;

    public static BufferedImage door, entrance, grass, dirt, player, ally, enemy, wall, genius,reset,menu,next;
    public static BufferedImage goal, character, right, left, down, up;
    public static BufferedImage gameA1, gameA2, gameB1, gameB2, gameC1, gameC2, menuBackground, gameOverBackground, winBackground, retry1, retry2, menu1, menu2;
    
	public static BufferedImage player_front[], player_back[], player_right[], player_left[];
	public static BufferedImage ally_front[], ally_back[], ally_right[], ally_left[];
	public static BufferedImage enemy_front[], enemy_back[], enemy_right[], enemy_left[];
    
    //init images to be displayed
    public static void init(){
        SpriteSheet sheet;
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Characters.png"));
        
        player=sheet.crop(9*width,4*height,width,height);
        ally=sheet.crop(0,0,width,height);
        enemy=sheet.crop(3*width,4*height,width,height);
        
		player_front= new BufferedImage[3];
		player_right= new BufferedImage[3];
		player_left= new BufferedImage[3];
		player_back= new BufferedImage[3];
		
		ally_front= new BufferedImage[3];
		ally_right= new BufferedImage[3];
		ally_left= new BufferedImage[3];
		ally_back= new BufferedImage[3];
		
		enemy_front= new BufferedImage[3];
		enemy_right= new BufferedImage[3];
		enemy_left= new BufferedImage[3];
		enemy_back= new BufferedImage[3];
		
		
		sheet = new SpriteSheet(ImageLoader.loadImage("/textures/Characters.png"));

		

		// Player Animation

		player_front[0] = sheet.crop(3 * width, 0, width, height);
		player_front[1] = sheet.crop(4 * width, 0, width, height);
		player_front[2] = sheet.crop(5 * width, 0, width, height);

		player_right[0] = sheet.crop(3 * width, 2 * height, width, height);
		player_right[1] = sheet.crop(4 * width, 2 * height, width, height);
		player_right[2] = sheet.crop(5 * width, 2 * height, width, height);

		player_left[0] = sheet.crop(3 * width, height, width, height);
		player_left[1] = sheet.crop(4 * width, height, width, height);
		player_left[2] = sheet.crop(5 * width, height, width, height);

		player_back[0] = sheet.crop(3 * width, 3 * height, width, height);
		player_back[1] = sheet.crop(4 * width, 3 * height, width, height);
		player_back[2] = sheet.crop(5 * width, 3 * height, width, height);

		// Ally Animation

		ally_front[0] = sheet.crop(0, 0, width, height);
		ally_front[1] = sheet.crop(1 * width, 0, width, height);
		ally_front[2] = sheet.crop(2 * width, 0, width, height);

		ally_right[0] = sheet.crop(0, 2 * height, width, height);
		ally_right[1] = sheet.crop(width, 2 * height, width, height);
		ally_right[2] = sheet.crop(2 * width, 2 * height, width, height);

		ally_left[0] = sheet.crop(0, height, width, height);
		ally_left[1] = sheet.crop(width, height, width, height);
		ally_left[2] = sheet.crop(2 * width, height, width, height);

		ally_back[0] = sheet.crop(0, 3 * height, width, height);
		ally_back[1] = sheet.crop(width, 3 * height, width, height);
		ally_back[2] = sheet.crop(2 * width, 3 * height, width, height);

		// Enemy animation

		enemy_front[0] = sheet.crop(6 * width, 0, width, height);
		enemy_front[1] = sheet.crop(7 * width, 0, width, height);
		enemy_front[2] = sheet.crop(8 * width, 0, width, height);

		enemy_right[0] = sheet.crop(6 * width, 2 * height, width, height);
		enemy_right[1] = sheet.crop(7 * width, 2 * height, width, height);
		enemy_right[2] = sheet.crop(8 * width, 2 * height, width, height);

		enemy_left[0] = sheet.crop(6 * width, height, width, height);
		enemy_left[1] = sheet.crop(7 * width, height, width, height);
		enemy_left[2] = sheet.crop(8 * width, height, width, height);

		enemy_back[0] = sheet.crop(6 * width, 3 * height, width, height);
		enemy_back[1] = sheet.crop(7 * width, 3 * height, width, height);
		enemy_back[2] = sheet.crop(8 * width, 3 * height, width, height);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/table.png"));

        grass = sheet.crop(0,0,width,height);
        dirt = sheet.crop(width,0,width,height);
        wall = sheet.crop(2*width,0,width,height);
        door = sheet.crop(3*width,0,width,height);
        
        entrance = sheet.crop(width,0,width,height);
        reset = sheet.crop(width,height,width,height);
        menu = sheet.crop(2*width,height,width,height);
        next = sheet.crop(3*width,height,width,height);


        //Part B
        character = sheet.crop(width*4,height*4,width,height);
        goal = sheet.crop(width*3,height*4,width,height);
        right = sheet.crop(width*2,height*4,width,height);
        left = sheet.crop(0,height*3,width,height);
        down = sheet.crop(width,height*4,width,height);
        up = sheet.crop(0,height*4,width,height);
        genius = sheet.crop(width*2,0,width,height);
        
        //menustates and game over
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/OPEN.png"));
        menuBackground=sheet.crop(0,0,screenWidth,screenHeight);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GAMEOVER.png"));
        gameOverBackground=sheet.crop(0,0,screenWidth,screenHeight);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/WIN.png"));
        winBackground=sheet.crop(0,0,screenWidth,screenHeight);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameA_bright.jpg"));
        gameA1=sheet.crop(0,0,400,200);
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameA_dark.jpg"));
        gameA2=sheet.crop(0,0,400,200);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameB_bright.jpg"));
        gameB1=sheet.crop(0,0,400,200);
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameB_dark.jpg"));
        gameB2=sheet.crop(0,0,400,200);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameC_bright.jpg"));
        gameC1=sheet.crop(0,0,400,200);
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/GameC_dark.jpg"));
        gameC2=sheet.crop(0,0,400,200);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/MENU.png"));
        menu1=sheet.crop(0,0,400,200);
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/MENU_bright.png"));
        menu2=sheet.crop(0, 0, 400, 200);
        
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/RETRY.png"));
        retry1=sheet.crop(0, 0, 400, 200);
        sheet = new SpriteSheet(ImageLoader.loadImage("/textures/RETRY_bright.png"));
        retry2=sheet.crop(0, 0, 400, 200);
        
        
   
        


    }
}
