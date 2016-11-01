package boardAction;

import web.Action;
import web.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action=null;
		
		if( "writeform".equals( actionName ) ) {
			action = new WriteFormAction();
		} else if( "delete".equals( actionName ) ) {
			action = new DeleteAction();
		} else if( "write".equals( actionName ) ) {
			action = new WriteAction();
		} else if( "view".equals( actionName ) ) {
			action = new ViewAction();
		} else {
			action = new ListAction();
		}
		return action;
	}

}
