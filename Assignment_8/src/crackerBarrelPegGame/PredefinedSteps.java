package crackerBarrelPegGame;

public class PredefinedSteps implements Iterable<Moves> {

	 public static final Moves[] Moves = 
		    {
		        new Moves(0, 1, 3),
		        new Moves(0, 2, 5),
		        new Moves(1, 3, 6),
		        new Moves(1, 4, 8),
		        new Moves(2, 4, 7),
		        new Moves(2, 5, 9),
		        new Moves(3, 6, 10),
		        new Moves(3, 7, 12),
		        new Moves(4, 7, 11),
		        new Moves(4, 8, 13),
		        new Moves(5, 8, 12),
		        new Moves(5, 9, 14),
		        new Moves(3, 4, 5),
		        new Moves(6, 7, 8),
		        new Moves(7, 8, 9),
		        new Moves(10, 11, 12),
		        new Moves(11, 12, 13),
		        new Moves(12, 13, 14)
		    };

	    @Override
	    public TraverseSteps iterator()
	    { return new TraverseSteps(Moves); }

}
