package patmat
import Huffman._

object week5 {
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4), Leaf('g', 5), Leaf('f', 6))
                                                  //> leaflist  : List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,4)
                                                  //| , Leaf(g,5), Leaf(f,6))

  combine(leaflist)                               //> res0: List[patmat.Huffman.CodeTree] = List(Fork(Leaf(e,1),Leaf(t,2),List(e, 
                                                  //| t),3), Fork(Leaf(x,4),Leaf(g,5),List(x, g),9), Leaf(f,6))

  createNode(Leaf('e', 1), Leaf('t', 2))          //> res1: patmat.Huffman.CodeTree = Fork(Leaf(e,1),Leaf(t,2),List(e, t),3)

  until(singleton, combine)(leaflist)             //> res2: patmat.Huffman.listT = List(Fork(Fork(Fork(Leaf(e,1),Leaf(t,2),List(e,
                                                  //|  t),3),Fork(Leaf(x,4),Leaf(g,5),List(x, g),9),List(e, t, x, g),12),Leaf(f,6)
                                                  //| ,List(e, t, x, g, f),18))

  val test = string2Chars("lunes a la manana en medrano")
                                                  //> test  : List[Char] = List(l, u, n, e, s,  , a,  , l, a,  , m, a, n, a, n, a,
                                                  //|   , e, n,  , m, e, d, r, a, n, o)
  val testTree = createCodeTree(test)             //> testTree  : patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Leaf(u,1),Leaf(s,1
                                                  //| ),List(u, s),2),Fork(Leaf(d,1),Leaf(r,1),List(d, r),2),List(u, s, d, r),4),F
                                                  //| ork(Fork(Leaf(o,1),Leaf(l,2),List(o, l),3),Fork(Leaf(m,2),Leaf(e,3),List(m, 
                                                  //| e),5),List(o, l, m, e),8),List(u, s, d, r, o, l, m, e),12),Fork(Fork(Leaf(n,
                                                  //| 5),Leaf( ,5),List(n,  ),10),Leaf(a,6),List(n,  , a),16),List(u, s, d, r, o, 
                                                  //| l, m, e, n,  , a),28)

  decodedSecret                                   //> res3: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

  encode(testTree)(test)                          //> res4: List[patmat.Huffman.Bit] = List(0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1,
                                                  //|  1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 
                                                  //| 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0
                                                  //| , 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0,
                                                  //|  0)

  quickEncode(testTree)(test)                     //> res5: List[patmat.Huffman.Bit] = List(0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1,
                                                  //|  1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 
                                                  //| 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0
                                                  //| , 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0,
                                                  //|  0)

  convert(testTree)                               //> res6: patmat.Huffman.CodeTable = List((u,List(0, 0, 0, 0)), (s,List(0, 0, 0,
                                                  //|  1)), (d,List(0, 0, 1, 0)), (r,List(0, 0, 1, 1)), (o,List(0, 1, 0, 0)), (l,L
                                                  //| ist(0, 1, 0, 1)), (m,List(0, 1, 1, 0)), (e,List(0, 1, 1, 1)), (n,List(1, 0, 
                                                  //| 0)), ( ,List(1, 0, 1)), (a,List(1, 1)))

}