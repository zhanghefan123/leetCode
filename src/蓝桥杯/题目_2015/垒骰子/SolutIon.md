# 1.动态规划解法

$$
dp\left[ i \right] \left[ j \right] \,\,\text{表示在}i\text{层}j\text{朝上的方案数},op\left[ j \right] \text{表示}j\text{的对面的面值}
\\
dp\left[ i \right] \left[ j \right] \,\,=\,\,\sum_{x=1}^6{dp\left[ i-1 \right] \left[ x \right] \,\,}| op\left[ j \right] \,\,\text{与} x\text{不冲突}
\\
ans\,\,=\,\,\sum_{j=1}^6{dp\left[ n \right] \left[ j \right]}
$$