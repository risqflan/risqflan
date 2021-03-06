/*
 * generated by Xtext 2.13.0
 */
package atree.xtext.ui.outline

import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.IOutlineNode
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.emf.ecore.EObject
import atree.xtext.bbt.Expression
import atree.xtext.bbt.BoolExpr
import atree.xtext.bbt.Variable
import atree.xtext.bbt.AttributeValue
//import atree.xtext.bbt.ProbabilityValue
//import atree.xtext.bbt.SuccessFailure
import atree.xtext.bbt.SideEffect
import atree.xtext.bbt.ORRelation
import atree.xtext.bbt.ANDRelation
import atree.xtext.bbt.OANDRelation
import atree.xtext.bbt.KNRelation
import atree.xtext.bbt.Analysis
import atree.xtext.bbt.ActionRequires
import atree.xtext.bbt.DefenseEffectivenessValues

/**
 * Customization of the default outline structure.
 *
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#outline
 */
class BbtOutlineTreeProvider extends DefaultOutlineTreeProvider {
	
	override IOutlineNode createRoot(IXtextDocument document) {
		//Thanks to this method the root in the outline will be the model definition, rather than the name of the file
		var documentNode = super.createRoot(document)
		if(documentNode.children.size>0)
		{
			return documentNode.children.get(0);	
		}
		return documentNode;
	}
	
	override protected _isLeaf(EObject modelElement) {
		var ret = super._isLeaf(modelElement); 
		if(modelElement instanceof Expression ||
			modelElement instanceof BoolExpr ||
			modelElement instanceof Variable ||
			modelElement instanceof AttributeValue ||
//			modelElement instanceof ProbabilityValue ||
//			modelElement instanceof SuccessFailure ||
			modelElement instanceof SideEffect ||
			modelElement instanceof ORRelation ||
			modelElement instanceof ANDRelation ||
			modelElement instanceof OANDRelation ||
//			modelElement instanceof ActionGuards ||
			modelElement instanceof KNRelation ||
			modelElement instanceof Analysis ||
			modelElement instanceof DefenseEffectivenessValues ||
			modelElement instanceof ActionRequires)
		{
			ret = true;
		}
		return ret;
	}
}
