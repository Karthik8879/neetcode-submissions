class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        island = 0
        row = len(grid)
        col = len(grid[0])

        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1':
                    island += 1
                    self.helper(grid, i, j)
        return island

    def helper(self, grid, r, c):
        q = deque()
        dr = [-1, 0, 1, 0]
        dc = [0, -1, 0, 1]
            
        q.append((r, c))
        grid[r][c] = "0"

        while q:
            curr = q.popleft()
            currr = curr[0]
            currc = curr[1]
            for k in range(4):
                nr = currr + dr[k]
                nc = currc + dc[k]
                if nr >= 0 and nc >= 0 and nr < len(grid) and nc < len(grid[0]) and grid[nr][nc] == '1':
                    q.append((nr, nc))
                    grid[nr][nc] = "0"
    