/* Generated By:JJTree: Do not edit this line. ASTExpression.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package uk.ac.ox.comlab.diadem.oxpath.parser.ast;

import uk.ac.ox.comlab.diadem.oxpath.parser.*;

public
class ASTExpression extends SimpleNode {
  public ASTExpression(int id) {
    super(id);
  }

  public ASTExpression(OXPathParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(OXPathParserVisitor visitor, Object data) throws uk.ac.ox.comlab.diadem.oxpath.utils.OXPathException {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=bcb390ffaa9961dbaedabbfec03d40b4 (do not edit this line) */