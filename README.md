# PyramidCalculator
Calculate 𝑏𝑎𝑠𝑒𝐴𝑟𝑒𝑎 and 𝑣𝑜𝑙𝑢𝑚𝑒 of Pyramid which has N-sided regular polygon for the base

The class stores the following three properties.
1) The Number of sides of the base polygon; name the property baseN. The property type must be int and the property value must be more than two.
𝑏𝑎𝑠𝑒𝑁>2
2) The Side length of the regular polygon in the base; name the property baseSide. The property type must be double and the property value must be positive.
𝑏𝑎𝑠𝑒𝑆𝑖𝑑𝑒>0
3) The height of the pyramid; name the property height. The property type must be double and the property value must be positive.
ℎ𝑒𝑖𝑔ℎ𝑡>0
4) This class validates the properties and throw IllegalArgumentException in cases of invalid property value setting.
5) Define the instance method getBaseArea() that calculates the area of the base of the pyramid using the formula 𝑏𝑎𝑠𝑒𝐴𝑟𝑒𝑎= 𝑏𝑎𝑠𝑒𝑁 × 𝑏𝑎𝑠𝑒𝑆𝑖𝑑𝑒2/(4tan(𝜋/𝑏𝑎𝑠𝑒𝑁))
6) Define the instance method getVolume() that calculates the volume of the pyramid using the getBaseArea() method and the formula below. 𝑣𝑜𝑙𝑢𝑚𝑒=𝑏𝑎𝑠𝑒𝐴𝑟𝑒𝑎 × ℎ𝑒𝑖𝑔ℎ𝑡/3
7) PyramidCalculator application calculates pyramid’s baseArea and volume from baseN, baseSide, and height.
8) The program re-adjust the screen, and behave correctly during rotations.
9) The program preserves its state (in shared preferences) before it exits and recover the state when it is restarted.
