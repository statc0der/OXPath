/* Generated By:JJTree: Do not edit this line. ASTXPathUnaryExpr.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package uk.ac.ox.comlab.diadem.oxpath.parser.ast;

import uk.ac.ox.comlab.diadem.oxpath.parser.*;

public
class ASTXPathUnaryExpr extends SimpleNode {
  public ASTXPathUnaryExpr(int id) {
    super(id);
  }

  public ASTXPathUnaryExpr(OXPathParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(OXPathParserVisitor visitor, Object data) throws uk.ac.ox.comlab.diadem.oxpath.utils.OXPathException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=2b8a64e0094cc8dda28295d58f75f558 (do not edit this line) */