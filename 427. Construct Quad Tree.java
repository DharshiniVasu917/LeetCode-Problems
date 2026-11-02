/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        return constructNode(grid, 0, rows - 1, 0, cols - 1);
    }

    public Node constructNode(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        if(isGridLeaf(grid, rowStart, rowEnd, colStart, colEnd)) {
            return new Node(grid[rowStart][colStart] == 1, true);
        } else {
            Node node = new Node(false, false);

            int rowHalf = rowStart + (rowEnd - rowStart) / 2, colHalf = colStart + (colEnd - colStart) / 2;

            node.topLeft = constructNode(grid, rowStart, rowHalf, colStart, colHalf);
            node.topRight = constructNode(grid, rowStart, rowHalf, colHalf + 1, colEnd);
            node.bottomLeft = constructNode(grid, rowHalf + 1, rowEnd, colStart, colHalf);
            node.bottomRight = constructNode(grid, rowHalf + 1, rowEnd, colHalf + 1, colEnd);

            return node;
        }
    }

    public boolean isGridLeaf(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        for(int i = rowStart; i <= rowEnd; i++) {
            for(int j = colStart; j <= colEnd; j++) {
                if(grid[i][j] != grid[rowStart][colStart]) return false;
            }
        }

        return true;
    }
}
