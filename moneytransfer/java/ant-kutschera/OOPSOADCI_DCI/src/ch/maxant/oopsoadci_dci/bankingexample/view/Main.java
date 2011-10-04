/*
 * Copyright (c) 2010 Ant Kutschera, maxant
 * 
 * This file is part of Ant Kutschera's blog.
 * 
 * This is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 * You should have received a copy of the Lesser GNU General Public License
 * along with this software.  If not, see <http://www.gnu.org/licenses/>.
 */
package ch.maxant.oopsoadci_dci.bankingexample.view;

import ch.maxant.oopsoadci_common.bankingexample.controller.AbstractController;
import ch.maxant.oopsoadci_common.bankingexample.view.AbstractMain;
import ch.maxant.oopsoadci_dci.bankingexample.controller.DCIController;

/**
 * the view, in MVC, in this case for the DCI impl.  Run this to see DCI in action.
 */
public class Main extends AbstractMain {

	public static void main(String[] args) {

    	System.out.println("Starting DCI example...");
		new Main().run();
	}
	
	@Override
	protected AbstractController getController() {
		return new DCIController();
	}
}