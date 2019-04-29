/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  public static void testKeepOnlyBlue()
  {
    Picture arch = new Picture("arch.jpg");
    arch.explore();
    arch.onlyBlue();
    arch.explore();
  }
  public static void testNegate()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  public static void testGrayscale()
  {
    /*
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayscale();
    beach.explore();
    */  // OLD GRAYSCLAE TESTER

    //Same as Luminosity
  	Picture beach = new Picture("beach.jpg");
    beach.explore();
	  beach.grayscale();
	  beach.explore();
	  beach = new Picture("beach.jpg");
	  beach.grayscaleAverage();
	  beach.explore();
	  beach = new Picture("beach.jpg");
	  beach.grayscaleLightness();
	  beach.explore();
	  beach = new Picture("beach.jpg");
	  beach.grayscaleLuminosity();
	  beach.explore();
  }
  public static void testFixUnderwater()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.fixUnderwater();
    water.explore();
  }
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  public static void testMirrorHorizontal()
  {
    Picture butterfly = new Picture("butterfly1.jpg");
    butterfly.explore();
    butterfly.mirrorHorizontal();
    butterfly.explore();
  }
  public static void testMirrorHorizontalBotToTop()
  {
    Picture butterfly = new Picture("butterfly1.jpg");
    butterfly.explore();
    butterfly.mirrorHorizontalBotToTop();
    butterfly.explore();
  }
  public static void testMirrorDiagonal()
  {
    Picture butterfly = new Picture("beach.jpg");
    butterfly.explore();
    butterfly.mirrorDiagonal();
    butterfly.explore();
  }
  public static void testMirrorArms()
  {
    Picture snowman = new Picture("snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  public static void testMirrorGull()
  {
    Picture gull = new Picture("seagull.jpg");
    gull.explore();
    gull.mirrorGull();
    gull.explore();
  }
  public static void testMirrorRectangle() {
    /*
	  Picture seagull = new Picture("seagull.jpg");
	  seagull.explore();
	  seagull.mirrorRectangle(232, 238, 322, 344, true);
	  seagull.explore();
    */
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
    snowman.mirrorRectangle(104, 157, 170, 191, false);
		snowman.mirrorRectangle(239, 170, 294, 190, false);
	  snowman.explore();
  }
  public static void testCopy()
  {
	  Picture canvas = new Picture("640x480.jpg");
	  canvas.copy(new Picture("beach.jpg"), 0, 0, 200, 200, 0, 0);
	  canvas.explore();
  }
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  public static void testCollageCreate()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.collageCreate();
    canvas.explore();
  }
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testEdgeDetection2()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection2(10);
    swan.explore();
  }

  public static void testBlur(int x, int y, int w, int h, int n)
{
   Picture redMoto = new Picture("redMotorcycle.jpg");
   redMoto.explore();
   for (int i = 0; i<n; i++){
      redMoto.blur(x,y,w,h);
    }
   redMoto.explore();
}

  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    x.testBlur(150,160,50,50,10);
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
  //  testZeroBlue();
  //  testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
  //  testNegate();
  //  testGrayscale();
  //  testFixUnderwater();
  //  testMirrorHorizontal();
  //  testMirrorHorizontalBotToTop();
  //  testMirrorVerticalRightToLeft();
  //  testMirrorVertical();
  //  testMirrorTemple();
  //  testMirrorArms();
  //  testMirrorGull();
  //  testMirrorDiagonal();
  //  testCollage();
  //  testCollageCreate();
  // testCopy();
  //  testBlur(180,160,25,25,10); 
  //  testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}
