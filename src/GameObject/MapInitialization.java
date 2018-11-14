package GameObject;

public class MapInitialization {
  public static int[][] wallLocation;
  public static int Score;
  public static int life;
  public static boolean split;
  public static int numBiglegs;
  public static int lvl;
  
  public MapInitialization() {
    wallLocation = new int[15][30];
    Score = 0;
    life = 4;
    split = false;
    setMapLvl1();
  }
  
  public void setMapLvl2() {
    wallLocation = new int[15][30];
    numBiglegs = 3;
    lvl = 2;
    for ( int i = 7; i > 0; i-- ) {
      for ( int j = 8-i; j < 8; j++ ) {
        wallLocation[i][j] = 1;
      }
    }
    for ( int i = 13; i > 7; i-- ) {
      for ( int j = i-6; j < 8; j++ ) {
        wallLocation[i][j] = 1;
      }
    }
    for ( int i = 1; i < 8; i++ ) {
      for ( int j = 8; j < i+8; j++ ) {
        wallLocation[i][j] = 1;
      }
    }
    for ( int i = 8; i < 14; i++ ) {
      for ( int j = 8; j < 22-i; j++ ) {
        wallLocation[i][j] = 1;
      }
    }
    
    for ( int i = 7; i > 1; i-- ) {
      for ( int j = 9-i; j < 8; j++ ) {
        wallLocation[i][j] = 2;
      }
    }
    for ( int i = 12; i > 7; i-- ) {
      for ( int j = i-5; j < 8; j++ ) {
        wallLocation[i][j] = 2;
      }
    }
    for ( int i = 2; i < 8; i++ ) {
      for ( int j = 8; j < i+7; j++ ) {
        wallLocation[i][j] = 2;
      }
    }
    for ( int i = 8; i < 13; i++ ) {
      for ( int j = 8; j < 21-i; j++ ) {
        wallLocation[i][j] = 2;
      }
    }
    
    for ( int i = 7; i > 2; i-- ) {
      for ( int j = 10-i; j < 8; j++ ) {
        wallLocation[i][j] = 3;
      }
    }
    for ( int i = 11; i > 7; i-- ) {
      for ( int j = i-4; j < 8; j++ ) {
        wallLocation[i][j] = 3;
      }
    }
    for ( int i = 3; i < 8; i++ ) {
      for ( int j = 8; j < i+6; j++ ) {
        wallLocation[i][j] = 3;
      }
    }
    for ( int i = 8; i < 12; i++ ) {
      for ( int j = 8; j < 20-i; j++ ) {
        wallLocation[i][j] = 3;
      }
    }
    
    for ( int i = 7; i > 3; i-- ) {
      for ( int j = 11-i; j < 8; j++ ) {
        wallLocation[i][j] = 4;
      }
    }
    for ( int i = 10; i > 7; i-- ) {
      for ( int j = i-3; j < 8; j++ ) {
        wallLocation[i][j] = 4;
      }
    }
    for ( int i = 4; i < 8; i++ ) {
      for ( int j = 8; j < i+5; j++ ) {
        wallLocation[i][j] = 4;
      }
    }
    for ( int i = 8; i < 11; i++ ) {
      for ( int j = 8; j < 19-i; j++ ) {
        wallLocation[i][j] = 4;
      }
    }
    
    for ( int i = 7; i > 4; i-- ) {
      for ( int j = 12-i; j < 8; j++ ) {
        wallLocation[i][j] = 5;
      }
    }
    for ( int i = 9; i > 7; i-- ) {
      for ( int j = i-2; j < 8; j++ ) {
        wallLocation[i][j] = 5;
      }
    }
    for ( int i = 5; i < 8; i++ ) {
      for ( int j = 8; j < i+4; j++ ) {
        wallLocation[i][j] = 5;
      }
    }
    for ( int i = 8; i < 10; i++ ) {
      for ( int j = 8; j < 18-i; j++ ) {
        wallLocation[i][j] = 5;
      }
    }
    
    for ( int i = 7; i > 5; i-- ) {
      for ( int j = 13-i; j < 8; j++ ) {
        wallLocation[i][j] = 6;
      }
    }
    for ( int i = 8; i > 7; i-- ) {
      for ( int j = i-1; j < 8; j++ ) {
        wallLocation[i][j] = 6;
      }
    }
    for ( int i = 6; i < 8; i++ ) {
      for ( int j = 8; j < i+3; j++ ) {
        wallLocation[i][j] = 6;
      }
    }
    for ( int i = 8; i < 9; i++ ) {
      for ( int j = 8; j < 17-i; j++ ) {
        wallLocation[i][j] = 6;
      }
    }
    
    wallLocation[7][7] = -2;
    wallLocation[7][8] = -4;
    
    wallLocation[0][13] = -1;
    wallLocation[1][13] = -1;
    wallLocation[14][13] = -1;
    wallLocation[13][13] = -1;
   
    wallLocation[4][14] = -1;
    wallLocation[7][9] = -1;    
    wallLocation[10][14] = -1;
    
    wallLocation[0][0] = 8;
    wallLocation[14][0] = 8;
    wallLocation[0][1] = 7;
    wallLocation[1][0] = 7;
    wallLocation[1][1] = 7;
    wallLocation[14][1] = 7;
    wallLocation[13][0] = 7;
    wallLocation[13][1] = 7;
    
    wallLocation[3][0] = -1;
    wallLocation[3][1] = -1;
    wallLocation[11][0] = -1;
    wallLocation[11][1] = -1;
    
    wallLocation[2][0] = -2;
    wallLocation[2][1] = -4;
    
    wallLocation[12][0] = -2;
    wallLocation[12][1] = -4;
    
    for ( int i = 0; i < 4; i++ ) {
      wallLocation[i][2] = 4;
    }
    for ( int i = 11; i < 15; i++ ) {
      wallLocation[i][2] = 4;
    }
    
    wallLocation[7][0] = -3;
    wallLocation[2][5] = -3;
    wallLocation[12][5] = -3;
  }
  
  /* 8=> life block, -1 => solid block, -2 => biglegs's up body, -3 => split, -4 => biglegs's down body*/
  public void setMapLvl1() {
    numBiglegs = 3;
    lvl = 1;
    for ( int j = 0; j < 12; j++ ) {
      wallLocation[2][j] = -1;
      wallLocation[5][j] = -1;
      wallLocation[9][j] = -1;
      wallLocation[12][j] = -1;
      
      wallLocation[1][j] = 3;
      wallLocation[13][j] = 3;
      
      wallLocation[3][j] = 2;
      wallLocation[11][j] = 2;
      
      wallLocation[4][j] = 4;
      wallLocation[10][j] = 4;
      
      wallLocation[6][j] = 1;
      wallLocation[8][j] = 1;
      
      wallLocation[7][j] = 7;
      
      //wallLocation[7][11] = -3;
      
      wallLocation[0][j] = 6;
      wallLocation[14][j] = 6;
    }
    
    wallLocation[1][0] = 8;
    wallLocation[0][0] = 8;
    wallLocation[13][0] = 8;
    wallLocation[14][0] = 8;
    
    wallLocation[3][0] = -2;
    wallLocation[11][0] = -2;
    wallLocation[3][1] = -4;
    wallLocation[11][1] = -4;
    wallLocation[7][0] = -2;
    wallLocation[7][1] = -4;
    
    wallLocation[3][8] = -3;
    wallLocation[4][6] = -3;
    
    wallLocation[10][6] = -3;
    wallLocation[11][8] = -3;
    
  }
}
