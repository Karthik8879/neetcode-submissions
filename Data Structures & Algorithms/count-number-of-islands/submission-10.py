class Solution:
    DIRS = [(0, 1), (0, -1), (-1, 0), (1, 0)]

    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        cnt = 0
        n = len(grid)
        m = len(grid[0])

        for i in range(n):
            for j in range(m):
                if grid[i][j] == "1":
                    cnt += 1
                    self.dfs(grid, i, j, n, m)
        return cnt

    
    def dfs(self, grid, row, col, n, m):
        # base case --> boundry val check
        if row < 0 or col < 0 or row >= n or col >= m:
            return
        # base case --> water or already visited
        if grid[row][col] != "1":
            return
        
        # mark as visited
        grid[row][col] = "0"

        for dr, dc in self.DIRS:
            new_row = row + dr
            new_col = col + dc
            self.dfs(grid, new_row, new_col, n, m)