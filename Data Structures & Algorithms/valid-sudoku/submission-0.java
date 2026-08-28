class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        int n1 = board[0].length;
        HashMap<Integer,Set<Integer>> seenRow = new HashMap<>(n1); // key is row idx
        HashMap<Integer,Set<Integer>> seenCol = new HashMap<>(n1); // key is col idx
        HashMap<Coord, Set<Integer>> seenBlock = new HashMap<>(); // coord = block
        
        for (int i = 0; i <n1; i++) {
            for (int j = 0; j <n1; j++) {
                if (Character.isDigit(board[i][j])) {
                    int val = board[i][j] -'1';
                    Coord p = new Coord(i/3, j/3);
                    
                    // build sets
                    seenRow.putIfAbsent(i, new HashSet<>());
                    seenCol.putIfAbsent(j, new HashSet<>());
                    seenBlock.putIfAbsent(p, new HashSet<>());

                    // check duplicates
                    if (seenRow.get(i).contains(val) ||
                        seenCol.get(j).contains(val) ||
                        seenBlock.get(p).contains(val)) {
                            return false;
                        }

                    // append new information to set
                    seenRow.get(i).add(val);
                    seenCol.get(j).add(val);
                    seenBlock.get(p).add(val);
                }
            }
        }
        return true;                     
    }
}

class Coord {
    private int x;
    private int y;
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // declare overide methods to allow comparison
    @Override public boolean equals(Object o) {
        if (this == o) { // compare memory address
            return true;
        }
        //  type checking
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Coord casted = (Coord) o;
        return (this.x == casted.x && this.y == casted.y);
    }

    // redifine hash criteria
    @Override public int hashCode() {
        return Objects.hash(x,y);
    }
}