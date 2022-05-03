package crackerBarrelPegGame;

public class Board extends Moves{

    
	public int pegSize;
    public int[] boardPosition;

    public Board(int emptyCell)
    {
    	super(emptyCell, emptyCell, emptyCell);
        boardPosition = new int[15];
        pegSize = 14;
        for (int i = 0; i < 15; i++)
            boardPosition[i] = i == emptyCell ? 0 : 1;
    }

    public Board(int pegSize, int[] boardPosition)
    {
    	super(pegSize, pegSize, pegSize);
        this.pegSize = pegSize;
        this.boardPosition    = boardPosition.clone();
    }

    public Board move(Moves move)
    {
        if (boardPosition[move.from] == 1 && 
            boardPosition[move.over] == 1 && 
            boardPosition[move.to]   == 0) 
        {
            Board boardAfter = new Board(pegSize-1, boardPosition.clone());
            boardAfter.boardPosition[move.from] = 0;
            boardAfter.boardPosition[move.over] = 0;
            boardAfter.boardPosition[move.to]   = 1;

            return boardAfter;
        }

        return null;
    }
}
