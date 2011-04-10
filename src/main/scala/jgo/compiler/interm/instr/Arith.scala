package jgo.compiler
package interm
package instr

sealed abstract class Arith
sealed abstract class Integral extends Arith
sealed abstract class Unsigned extends Integral

case object I8  extends Integral
case object I16 extends Integral
case object I32 extends Integral
case object I64 extends Integral

case object U8  extends Unsigned
case object U16 extends Unsigned
case object U32 extends Unsigned
case object U64 extends Unsigned

case object F32 extends Arith
case object F64 extends Arith

//case object C64  extends Arith
//case object C128 extends Arith