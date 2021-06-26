public class Field
{
    // grid
    int size = 50;
    int[][] grid;

    public Field()
    {
        grid = new int[size][size];
    }

    public int[][] getGrid()
    {
        return grid;
    }

    public void action()
    {
        int[][] temp = new int[size][size];

        for(int i = 1; i < size-1; i++)
        {
            for(int j = 1; j < size-1; j++)
            {
                int neighbors = 0;

                if(grid[i-1][j-1] == 1)
                    neighbors++;
                if(grid[i-1][j] == 1)
                    neighbors++;
                if(grid[i-1][j+1] == 1)
                    neighbors++;
                if(grid[i][j-1] == 1)
                    neighbors++;
                if(grid[i][j+1] == 1)
                    neighbors++;
                if(grid[i+1][j-1] == 1)
                    neighbors++;
                if(grid[i+1][j] == 1)
                    neighbors++;
                if(grid[i+1][j+1] == 1)
                    neighbors++;

                if(neighbors < 2 || neighbors > 3)
                    temp[i][j] = 0;
                if(neighbors == 3)
                    temp[i][j] = 1;
                if(neighbors == 2 && grid[i][j] == 0)
                    temp[i][j] = 0;
                if(neighbors == 2 && grid[i][j] == 1)
                    temp[i][j] = 1;
            }
        }
        grid = temp;
    }
}
