package crackerBarrelPegGame;

public class Moves {
	public int from; 
    public int over; 
    public int to; 

    public Moves(int from, int over, int to)
    {
        this.from = from;
        this.over = over;
        this.to   = to;
    }

    public Moves reverseMoves() 
    { return new Moves(to, over, from); }

    @Override
    public String toString()
    {
        return "(" + from + ", " + over + ", " + to + ")";
    }
}


