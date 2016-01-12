
* 引入方式:
<script type="text/javascript" src="${ctx}views/commonjs/decimal/decimal.min.js"></script>

*使用方法:
//加减乘除
//plus, minus, times, dividedBy

x = new Decimal(1011, 2)             // '11'
y = new Decimal('zz.9', 36)          // '1295.25'
z = x.plus(y)                        // '1306.25'

//
0.3 - 0.1                     // 0.19999999999999998
x = new Decimal(0.3)
x.minus(0.1)                  // '0.2'
x                             // '0.3'

//
x.dividedBy(y).plus(z).times(9).floor()
x.times('1.23456780123456789e+9').plus(9876.5432321).dividedBy('4444562598.111772').ceil()

//
x = new Decimal(255.5)
x.toExponential(5)              // '2.55500e+2'
x.toFixed(5)                    // '255.50000'
x.toPrecision(5)                // '255.50'


