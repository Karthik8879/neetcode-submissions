class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        island = 0
        row = len(grid)
        col = len(grid[0])
        vis = [[False] * col for _ in range(row)]

        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1' and not vis[i][j]:
                    island += 1
                    self.helper(grid, i, j, vis)
        return island

    def helper(self, grid, r, c, vis):
        q = deque()
        dr = [-1, 0, 1, 0]
        dc = [0, -1, 0, 1]
            
        q.append((r, c))
        vis[r][c] = True

        while q:
            curr = q.popleft()
            currr = curr[0]
            currc = curr[1]
            for k in range(4):
                nr = currr + dr[k]
                nc = currc + dc[k]
                if nr >= 0 and nc >= 0 and nr < len(grid) and nc < len(grid[0]) and grid[nr][nc] == '1' and not vis[nr][nc]:
                    vis[nr][nc] = True
                    q.append((nr, nc))
    