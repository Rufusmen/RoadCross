public class Colider {
    private int size;
    private Car owner;

    public Colider( Car owner){
        this.size = 20;
        this.owner = owner;
    }


    public boolean intersects(Colider s){
        return contains(s) || s.contains(this);
    }

    private boolean contains(Colider s){
        return contains(s.getLeft(), s.getTop()) || contains(s.getRight(), s.getTop())
                || contains(s.getLeft(),s.getBottom()) || contains(s.getRight(),s.getBottom());
    }

    private boolean contains(float x, float y){
        return getLeft() <= x && x <= getRight()
                && getTop()<= y && y <= getBottom();
    }

    public int getLeft(){
        return owner.getX()-size/2;
    }
    public int getRight(){
        return owner.getX()+size/2;
    }
    public int getTop(){
        return owner.getY()-size/2;
    }
    public int getBottom(){
        return owner.getY()+size/2;
    }
}
