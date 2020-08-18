package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.BillboardControl;
import com.jme3.scene.shape.Box;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 *
 * @author normenhansen
 */
public class Main extends SimpleApplication implements ActionListener {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    private Node sceneNode;
    private BulletAppState bulletAppState;
    private RigidBodyControl scenePhy;
    private RigidBodyControl scenePhy1;
    private Node playerNode;
    private CharacterControl playerControl;
    private CameraNode camNode;
    private Vector3f walkDirection = new Vector3f(0, 0, 0);
    private Vector3f viewDirection = new Vector3f(0, 0, 1);
    private Vector3f subtractor = new Vector3f(1000, 0, 1000);
    private boolean Left = false, Right = false, forward = false, backward = false;
    private float speed = 8;
    private Vector3f camDir = new Vector3f();
    private Vector3f camLeft = new Vector3f();
    private BitmapText ch;
    private Node Palace;
    private Node Couch;
    private Geometry beanbagChair;
    private Node speaker;
    private Geometry wallshelves;
    private Geometry chair;
    private Geometry fridge;
    private Geometry ceilingLamp;
    private Geometry faucet;
    private Geometry frame;
    private Geometry bed;
    private Node bedchair;
    private Geometry vase;
    private Node tvshelf;
    private Material darkred;

    @Override
    public void simpleInitApp() {
               
        /*guiFont = assetManager.loadFont("Interface/Fonts/ComicSansMS.fnt");
        
        ch = new BitmapText(guiFont, false);
        ch.setSize(guiFont.getCharSet().getRenderedSize()*2);
        ch.setText("COORDS");
        ch.setColor(ColorRGBA.Green);
        guiNode.attachChild(ch);*/
        
        setDisplayFps(false);

        setDisplayStatView(false);
        
        BillboardControl billboard1 = new BillboardControl();
        BillboardControl billboard2 = new BillboardControl();
        BillboardControl billboard3 = new BillboardControl();
        BillboardControl billboard4 = new BillboardControl();
        BillboardControl billboard5 = new BillboardControl();
        BillboardControl billboard6 = new BillboardControl();
        BillboardControl billboard7 = new BillboardControl();
        BillboardControl billboard8 = new BillboardControl();
        BillboardControl billboard9 = new BillboardControl();
        BillboardControl billboard10 = new BillboardControl();
        BillboardControl billboard11 = new BillboardControl();
        BillboardControl billboard12 = new BillboardControl();
        BillboardControl billboard13 = new BillboardControl();
        BillboardControl billboard14 = new BillboardControl();
        
        Box wordBox = new Box(1.5f, 0.5f, 0f);
        Material word1 = assetManager.loadMaterial("Materials/Word1.j3m");
        Material word2 = assetManager.loadMaterial("Materials/Word2.j3m");
        Material word3 = assetManager.loadMaterial("Materials/Word3.j3m");
        Material word4 = assetManager.loadMaterial("Materials/Word4.j3m");
        Material word5 = assetManager.loadMaterial("Materials/Word5.j3m");
        Material word6 = assetManager.loadMaterial("Materials/Word6.j3m");
        Material word7 = assetManager.loadMaterial("Materials/Word7.j3m");
        Material word8 = assetManager.loadMaterial("Materials/Word8.j3m");
        Material word9 = assetManager.loadMaterial("Materials/Word9.j3m");
        Material word10 = assetManager.loadMaterial("Materials/Word10.j3m");
        Material word11 = assetManager.loadMaterial("Materials/Word11.j3m");
        Material word12 = assetManager.loadMaterial("Materials/Word12.j3m");
        Material word13 = assetManager.loadMaterial("Materials/Word13.j3m");
        Material word14 = assetManager.loadMaterial("Materials/Word14.j3m");
        
        Geometry wordGeom1 = new Geometry("Box", wordBox);
        wordGeom1.setMaterial(word1);
        wordGeom1.addControl(billboard1);
        wordGeom1.setLocalTranslation(new Vector3f(-12.74f, 0.0f, 4.84f));
        rootNode.attachChild(wordGeom1);
        
        Geometry wordGeom2 = new Geometry("Box", wordBox);
        wordGeom2.setMaterial(word2);
        wordGeom2.addControl(billboard2);
        wordGeom2.setLocalTranslation(new Vector3f(-4.92f, -1.0f, 8.99f));
        rootNode.attachChild(wordGeom2);
        
        Geometry wordGeom3 = new Geometry("Box", wordBox);
        wordGeom3.setMaterial(word3);
        wordGeom3.addControl(billboard3);
        wordGeom3.setLocalTranslation(new Vector3f(12.78f, 2.36f, -6f));
        rootNode.attachChild(wordGeom3);
        
        Geometry wordGeom4 = new Geometry("Box", wordBox);
        wordGeom4.setMaterial(word4);
        wordGeom4.addControl(billboard4);
        wordGeom4.setLocalTranslation(new Vector3f(20.84f, 1.16f, 7.29f));
        rootNode.attachChild(wordGeom4);
        
        Geometry wordGeom5 = new Geometry("Box", wordBox);
        wordGeom5.setMaterial(word5);
        wordGeom5.addControl(billboard5);
        wordGeom5.setLocalTranslation(new Vector3f(26.3f, 1.16f, 66.3f));
        rootNode.attachChild(wordGeom5);
        
        Geometry wordGeom6 = new Geometry("Box", wordBox);
        wordGeom6.setMaterial(word6);
        wordGeom6.addControl(billboard6);
        wordGeom6.setLocalTranslation(new Vector3f(34.06f, 5.16f, 64.3f));
        rootNode.attachChild(wordGeom6);
        
        Geometry wordGeom7 = new Geometry("Box", wordBox);
        wordGeom7.setMaterial(word7);
        wordGeom7.addControl(billboard7);
        wordGeom7.setLocalTranslation(new Vector3f(37.2f, 2.5f, 54.4f));
        rootNode.attachChild(wordGeom7);
        
        Geometry wordGeom8 = new Geometry("Box", wordBox);
        wordGeom8.setMaterial(word8);
        wordGeom8.addControl(billboard8);
        wordGeom8.setLocalTranslation(new Vector3f(47.5f, 2.16f, 58.8f));
        rootNode.attachChild(wordGeom8);
        
        Geometry wordGeom9 = new Geometry("Box", wordBox);
        wordGeom9.setMaterial(word9);
        wordGeom9.addControl(billboard9);
        wordGeom9.setLocalTranslation(new Vector3f(49f, 3.5f, 77.25f));
        rootNode.attachChild(wordGeom9);
        
        Geometry wordGeom10 = new Geometry("Box", wordBox);
        wordGeom10.setMaterial(word10);
        wordGeom10.addControl(billboard10);
        wordGeom10.setLocalTranslation(new Vector3f(33.4f, 3.5f, 96f));
        rootNode.attachChild(wordGeom10);
        
        Geometry wordGeom11 = new Geometry("Box", wordBox);
        wordGeom11.setMaterial(word11);
        wordGeom11.addControl(billboard11);
        wordGeom11.setLocalTranslation(new Vector3f(37f, -1f, 114f));
        rootNode.attachChild(wordGeom11);
        
        Geometry wordGeom12 = new Geometry("Box", wordBox);
        wordGeom12.setMaterial(word12);
        wordGeom12.addControl(billboard12);
        wordGeom12.setLocalTranslation(new Vector3f(27.5f, -1f, 127f));
        rootNode.attachChild(wordGeom12);
        
        Geometry wordGeom13 = new Geometry("Box", wordBox);
        wordGeom13.setMaterial(word13);
        wordGeom13.addControl(billboard13);
        wordGeom13.setLocalTranslation(new Vector3f(21f, 0f, 126f));
        rootNode.attachChild(wordGeom13);
        
        Geometry wordGeom14 = new Geometry("Box", wordBox);
        wordGeom14.setMaterial(word14);
        wordGeom14.addControl(billboard14);
        wordGeom14.setLocalTranslation(new Vector3f(20f, 0.5f, 114f));
        rootNode.attachChild(wordGeom14);
        
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        Node physNode = new Node();
        scenePhy = new RigidBodyControl(0f);

        Palace = (Node) assetManager.loadModel("Textures/Room/BarePalaceModel.j3o");
        Material palaceMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        TextureKey palaceT = new TextureKey("Textures/Room/darksilver.jpg");
        palaceMat.setTexture("DiffuseMap", assetManager.loadTexture(palaceT));
        Palace.setMaterial(palaceMat);
        Palace.scale(2f);
        Palace.move(5, -4f, 5);
        physNode.attachChild(Palace);
        
        Couch = (Node) assetManager.loadModel("Textures/Room/couch.j3o");
        Material couchMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        TextureKey T = new TextureKey("Textures/Room/darkblue.png");
        couchMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        Couch.setMaterial(couchMat);
        Couch.setLocalTranslation(16f, -4f, 4.84f);
        Couch.scale(1.5f);
        physNode.attachChild(Couch);
        
        beanbagChair = (Geometry) assetManager.loadModel("Textures/Room/beanbagchair.j3o");
        Material beanMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        couchMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        beanbagChair.setMaterial(couchMat);
        beanbagChair.scale(2f);
        beanbagChair.setLocalTranslation(32f, -4f, 7.5f);
        physNode.attachChild(beanbagChair);
        
        speaker = (Node) assetManager.loadModel("Textures/Room/speaker.j3o");
        Material speakerMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        speakerMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        speaker.setMaterial(speakerMat);
        speaker.scale(2f);
        speaker.setLocalTranslation(-19f, -3.5f, 5f);
        physNode.attachChild(speaker);
        
        wallshelves = (Geometry) assetManager.loadModel("Textures/Room/wallshelves.j3o");
        Material wallMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        wallMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        wallshelves.setMaterial(wallMat);
        wallshelves.scale(2f);
        wallshelves.setLocalTranslation(-25f, -1.5f, 5f);
        physNode.attachChild(wallshelves);
        
        chair = (Geometry) assetManager.loadModel("Textures/Room/foldingchair.j3o");
        Material chairMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        chairMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        chair.setMaterial(chairMat);
        chair.scale(0.05f);
        chair.move(30.5f, -4f, 53.5f);
        chair.rotate(0f, FastMath.DEG_TO_RAD * -90f, 0f);
        physNode.attachChild(chair);
        
        fridge = (Geometry) assetManager.loadModel("Textures/Room/fridge.j3o");
        Material fridgeMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        fridgeMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        fridge.setMaterial(fridgeMat);
        fridge.scale(0.05f);
        fridge.move(-3f, -3.5f, 53f);
        fridge.rotate(0f, FastMath.DEG_TO_RAD * -90f, 0f);
        physNode.attachChild(fridge);
        
        ceilingLamp = (Geometry) assetManager.loadModel("Textures/Room/ceilinglamp.j3o");
        Material ceilingLampMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        ceilingLampMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        ceilingLamp.setMaterial(ceilingLampMat);
        ceilingLamp.scale(0.05f);
        ceilingLamp.move(22.2f, -4.5f, 119f);
        physNode.attachChild(ceilingLamp);
        
        faucet = (Geometry) assetManager.loadModel("Textures/Room/faucet.j3o");
        Material faucetMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        faucetMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        faucet.setMaterial(faucetMat);
        faucet.scale(0.05f);
        faucet.move(50.5f, -4.1f, 53f);
        faucet.rotate(0f, FastMath.DEG_TO_RAD * -90f, 0f);
        physNode.attachChild(faucet);
        
        frame = (Geometry) assetManager.loadModel("Textures/Room/frame.j3o");
        Material frameMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        frameMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        frame.setMaterial(frameMat);
        frame.scale(0.6f);
        frame.move(33f, 0f, 97f);
        frame.rotate(0f, FastMath.DEG_TO_RAD * -90f, 0f);
        physNode.attachChild(frame);
        
        Box windowBox = new Box (2f, 4.3f, 1.8f);
        Geometry window = new Geometry("Box", windowBox);
        darkred = assetManager.loadMaterial("Materials/darkred.j3m");
        window.setMaterial(darkred);
        window.move(52f, 3.1f, 77.3f);
        physNode.attachChild(window);
        
        bed = (Geometry) assetManager.loadModel("Textures/Room/bed.j3o");
        Material bedMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        bedMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        bed.setMaterial(bedMat);
        bed.scale(0.08f);
        bed.move(25.5f, -4.1f, 141f);
        bed.rotate(0f, FastMath.DEG_TO_RAD * -90f, 0f);
        physNode.attachChild(bed);
        
        Box bedBox = new Box (5f, 0.1f, 4.5f);
        Geometry bedTop = new Geometry("Box", bedBox);
        bedTop.setMaterial(darkred);
        bedTop.move(38f, -2f, 114.7f);
        physNode.attachChild(bedTop);
        
        bedchair = (Node) assetManager.loadModel("Textures/Room/chair.j3o");
        Material bedchairMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        bedchairMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        bedchair.setMaterial(bedchairMat);
        bedchair.scale(0.08f);
        bedchair.move(22f, -4f, 97f);
        bedchair.rotate(0f, FastMath.DEG_TO_RAD * -90f, 0f);
        physNode.attachChild(bedchair);
        
        vase = (Geometry) assetManager.loadModel("Textures/Room/vase.j3o");
        Material vaseMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        vaseMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        vase.setMaterial(vaseMat);
        vase.scale(0.05f);
        vase.move(2f, -4f, 122f);
        physNode.attachChild(vase);
        
        tvshelf = (Node) assetManager.loadModel("Textures/Room/tvshelf.j3o");
        Material tvshelfMat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        tvshelfMat.setTexture("DiffuseMap", assetManager.loadTexture(T));
        tvshelf.setMaterial(tvshelfMat);
        tvshelf.scale(0.08f);
        tvshelf.move(27f, -4f, 89f);
        tvshelf.rotate(0f, FastMath.DEG_TO_RAD * -90f, 0f);
        physNode.attachChild(tvshelf);
        
        physNode.addControl(scenePhy);
        bulletAppState.getPhysicsSpace().add(physNode);
        rootNode.attachChild(physNode);

        playerNode = new Node("the player");
        playerNode.setLocalTranslation(new Vector3f(-11,8, 20));
        rootNode.attachChild(playerNode);
        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 7f, 1);
        playerControl = new CharacterControl(capsuleShape, 0.05f);
        playerControl.setGravity(new Vector3f(0, -30, 0));
        playerControl.setJumpSpeed(20);
        playerControl.setFallSpeed(30);
        playerNode.addControl(playerControl);
        bulletAppState.getPhysicsSpace().add(playerControl);

        inputManager.addMapping("Forward", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Back", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Rotate Left", new MouseAxisTrigger(MouseInput.AXIS_X, true));
        inputManager.addMapping("Rotate Right", new MouseAxisTrigger(MouseInput.AXIS_X, false));
        inputManager.addMapping("Rotate Up", new MouseAxisTrigger(MouseInput.AXIS_Y, true));
        inputManager.addMapping("Rotate Down", new MouseAxisTrigger(MouseInput.AXIS_Y, false));
        inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(this, "Forward", "Back", "Left", "Right", "Jump");

        AmbientLight ambient = new AmbientLight();
        rootNode.addLight(ambient);
        DirectionalLight sun = new DirectionalLight();
        sun.setDirection(new Vector3f(1.4f, -1.4f, -1.4f));
        rootNode.addLight(sun);
        viewPort.setBackgroundColor(ColorRGBA.Cyan);
    }

    public void onAction(String binding, boolean isPressed, float tpf) {
        if (binding.equals("Left")) {
            Left = isPressed;
        } else if (binding.equals("Right")) {
            Right = isPressed;
        } else if (binding.equals("Forward")) {
            forward = isPressed;
        } else if (binding.equals("Back")) {
            backward = isPressed;
        } else if (binding.equals("Jump") && playerNode.getLocalTranslation().getY() <= 6) {
            playerControl.jump(new Vector3f(0, 15f, 0));
        }
    }

    @Override
    public void simpleUpdate(float tpf) {
        camDir.set(cam.getDirection()).multLocal(0.4f);
        camLeft.set(cam.getLeft()).multLocal(0.2f);
        System.out.println(camDir);
        walkDirection.set(0, 0, 0);
        if (Left) {
            walkDirection.addLocal(camLeft);
        }
        if (Right) {
            walkDirection.addLocal(camLeft.negate());
        }
        if (forward) {
            walkDirection.addLocal(camDir);
        }
        if (backward) {
            walkDirection.addLocal(camDir.negate());
        }
        playerControl.setWalkDirection(walkDirection);
        cam.setLocation(playerControl.getPhysicsLocation());
        
        
        /*guiNode.getChild(0).setLocalTranslation(50, 100, 0);
        ch.setText("Coords:" + playerNode.getLocalTranslation());*/
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
