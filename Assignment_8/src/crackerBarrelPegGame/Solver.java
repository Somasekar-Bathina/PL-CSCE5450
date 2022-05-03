package crackerBarrelPegGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solver {

	 static PredefinedSteps steps() 
	    { return new PredefinedSteps(); }

	    static ArrayList<LinkedList<Moves>> solve(Board b)
	    {
	        ArrayList<LinkedList<Moves>> out = new ArrayList<LinkedList<Moves>>();
	        solve(b, out, 0);

	        return out;
	    }

	    static LinkedList<Moves> startGame(Board b)
	    {
	        ArrayList<LinkedList<Moves>> out = new ArrayList<LinkedList<Moves>>();
	        solve(b, out, 1);

	        if (out.size() == 0) 
	            return null;

	        return out.get(0);
	    }

	    static void solve(Board b, ArrayList<LinkedList<Moves>> solutions, int count)
	    {
	        if (b.pegSize == 1)
	        {
	            solutions.add(new LinkedList<Moves>());
	            return;
	        }

	        for (Moves m : steps()) 
	        {
	            Board boardAfter = b.move(m);
	            if (boardAfter == null) continue;

	            ArrayList<LinkedList<Moves>> tailSolutions = new ArrayList<LinkedList<Moves>>();
	            solve(boardAfter, tailSolutions, count);

	            for (LinkedList<Moves> solution : tailSolutions)
	            {
	                solution.add(0, m);
	                solutions.add(solution);

	                if (solutions.size() == count)
	                    return;
	            }
	        }
	    }

	    static void show(Board b)
	    {
	        int[][] lines = { {4,0,0}, {3,1,2}, {2,3,5}, {1,6,9}, {0,10,14} };
	        for (int[] l : lines)
	        {
	            int spaces = l[0];
	            int begin  = l[1];
	            int end    = l[2];

	            String space = new String();
	            for (int i = 0; i < spaces; i++)
	                space += " ";

	            System.out.print(space);
	            for (int i = begin; i <= end; i++)
	                System.out.print(b.boardPosition[i] == 0 ? ". " : "x ");

	            System.out.println();
	        }

	        System.out.println();
	    }

	    static void replay(List<Moves> moves, Board b)
	    {
	        show(b);
	        for (Moves m : moves)
	        {
	            b = b.move(m);
	            show(b);
	        }
	    }


	    static void playGame()
	    {
	        for (int i = 0; i < 5; i++)
	        {
	            System.out.println("=== " + i + " ===");
	            Board b = new Board(i);
	            replay(startGame(b), b);
	            System.out.println();
	        }
	    }

}
