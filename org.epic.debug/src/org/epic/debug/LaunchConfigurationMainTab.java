/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * @author ruehl
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

package org.epic.debug;

//import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
//import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
//import org.eclipse.swt.events.SelectionAdapter;
//import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
//import org.eclipse.ui.dialogs.ElementListSelectionDialog;
//import org.eclipse.ui.dialogs.SelectionDialog;
//import org.eclipse.ui.help.WorkbenchHelp;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.core.resources.IProject;





public class LaunchConfigurationMainTab
	extends AbstractLaunchConfigurationTab {

/**
 * A launch configuration tab that displays and edits project and
 * main type name launch configuration attributes.
 * <p>
 * This class may be instantiated. This class is not intended to be subclassed.
 * </p>
 * @since 2.0
 */

	// Project UI widgets
	protected Label fProjLabel;
	protected Text fProjText;
	protected Button fProjButton;

	// Main class UI widgets
	protected Label fMainLabel;
	protected Text fMainText;
//	protected Button fSearchButton;
//  protected Button fSearchExternalJarsCheckButton;
//	protected Button fStopInMainCheckButton;

	protected static final String EMPTY_STRING = ""; //$NON-NLS-1$

	
	
	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Font font = parent.getFont();

		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);
	
		GridLayout topLayout = new GridLayout();
		comp.setLayout(topLayout);
		GridData gd;

		createVerticalSpacer(comp, 1);

		Composite projComp = new Composite(comp, SWT.NONE);
		GridLayout projLayout = new GridLayout();
		projLayout.numColumns = 2;
		projLayout.marginHeight = 0;
		projLayout.marginWidth = 0;
		projComp.setLayout(projLayout);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		projComp.setLayoutData(gd);
		projComp.setFont(font);

		fProjLabel = new Label(projComp, SWT.NONE);
		fProjLabel.setText("&Project:"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalSpan = 2;
		fProjLabel.setLayoutData(gd);
		fProjLabel.setFont(font);

		fProjText = new Text(projComp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fProjText.setLayoutData(gd);
		fProjText.setFont(font);
		fProjText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});

		//fProjButton = createPushButton(projComp, "Browse..."), null); //$NON-NLS-1$
		/*fProjButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				handleProjectButtonSelected();
			}
		});
		*/

		createVerticalSpacer(comp, 1);

		Composite mainComp = new Composite(comp, SWT.NONE);
		GridLayout mainLayout = new GridLayout();
		mainLayout.numColumns = 2;
		mainLayout.marginHeight = 0;
		mainLayout.marginWidth = 0;
		mainComp.setLayout(mainLayout);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		mainComp.setLayoutData(gd);
		mainComp.setFont(font);

		fMainLabel = new Label(mainComp, SWT.NONE);
		fMainLabel.setText("File to execute"); //$NON-NLS-1$
		gd = new GridData();
		gd.horizontalSpan = 2;
		fMainLabel.setLayoutData(gd);
		fMainLabel.setFont(font);

		fMainText = new Text(mainComp, SWT.SINGLE | SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fMainText.setLayoutData(gd);
		fMainText.setFont(font);
		fMainText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});

	/*	fSearchButton = createPushButton(mainComp,LauncherMessages.getString("JavaMainTab.Searc&h_5"), null); //$NON-NLS-1$
		fSearchButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				handleSearchButtonSelected();
			}
		});

		fSearchExternalJarsCheckButton = new Button(mainComp, SWT.CHECK);
		fSearchExternalJarsCheckButton.setText(LauncherMessages.getString("JavaMainTab.E&xt._jars_6")); //$NON-NLS-1$
		fSearchExternalJarsCheckButton.setFont(font);
		fSearchExternalJarsCheckButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});

		fStopInMainCheckButton = new Button(comp, SWT.CHECK);
		fStopInMainCheckButton.setText(LauncherMessages.getString("JavaMainTab.St&op_in_main_1")); //$NON-NLS-1$
		fStopInMainCheckButton.setFont(font);
		fStopInMainCheckButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent evt) {
				updateLaunchConfigurationDialog();
			}
		});
		*/
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#initializeFrom(ILaunchConfiguration)
	 */
	public void initializeFrom(ILaunchConfiguration config) {
		updateProjectFromConfig(config);
		updateMainTypeFromConfig(config);
	}

	protected void updateProjectFromConfig(ILaunchConfiguration config) {
		String projectName = ""; //$NON-NLS-1$
		try {
			projectName = config.getAttribute(PerlLaunchConfigurationConstants.ATTR_PROJECT_NAME, EMPTY_STRING);
		} catch (CoreException ce) {
			PerlDebugPlugin.log(ce);
		}
		fProjText.setText(projectName);
	}

	protected void updateMainTypeFromConfig(ILaunchConfiguration config) {
		String mainTypeName = ""; //$NON-NLS-1$
		try {
			mainTypeName = config.getAttribute(PerlLaunchConfigurationConstants.ATTR_STARTUP_FILE, EMPTY_STRING);
		} catch (CoreException ce) {
			PerlDebugPlugin.log(ce);
		}
		fMainText.setText(mainTypeName);
	}

	
	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#performApply(ILaunchConfigurationWorkingCopy)
	 */
	public void performApply(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(PerlLaunchConfigurationConstants.ATTR_PROJECT_NAME, (String)fProjText.getText());
		config.setAttribute(PerlLaunchConfigurationConstants.ATTR_STARTUP_FILE, (String)fMainText.getText());
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#dispose()
	 */
	public void dispose() {
	}

	/**
	 * Show a dialog that lists all main types
	 */
	protected void handleSearchButtonSelected() {

	/*	IJavaProject javaProject = getJavaProject();
		IJavaSearchScope searchScope = null;
		if ((javaProject == null) || !javaProject.exists()) {
			searchScope = SearchEngine.createWorkspaceScope();
		} else {
			searchScope = SearchEngine.createJavaSearchScope(new IJavaElement[] {javaProject}, false);
		}

		int constraints = IJavaElementSearchConstants.CONSIDER_BINARIES;
		if (fSearchExternalJarsCheckButton.getSelection()) {
			constraints |= IJavaElementSearchConstants.CONSIDER_EXTERNAL_JARS;
		}

		Shell shell = getShell();
		SelectionDialog dialog = JavaUI.createMainTypeDialog(shell,
															 getLaunchConfigurationDialog(),
															 searchScope,
															 constraints,
															 false,
															 fMainText.getText());
		dialog.setTitle(LauncherMessages.getString("JavaMainTab.Choose_Main_Type_11")); //$NON-NLS-1$
		dialog.setMessage(LauncherMessages.getString("JavaMainTab.Choose_a_main_&type_to_launch__12")); //$NON-NLS-1$
		if (dialog.open() == SelectionDialog.CANCEL) {
			return;
		}

		Object[] results = dialog.getResult();
		if ((results == null) || (results.length < 1)) {
			return;
		}
		IType type = (IType)results[0];
		if (type != null) {
			fMainText.setText(type.getFullyQualifiedName());
			javaProject = type.getJavaProject();
			fProjText.setText(javaProject.getElementName());
		}*/
	}

	/**
	 * Show a dialog that lets the user select a project.  This in turn provides
	 * context for the main type, allowing the user to key a main type name, or
	 * constraining the search for main types to the specified project.
	 */
	protected void handleProjectButtonSelected() {
	/*	IJavaProject project = chooseJavaProject();
		if (project == null) {
			return;
		}

		String projectName = project.getElementName();
		fProjText.setText(projectName);*/
	}

	/**
	 * Realize a Java Project selection dialog and return the first selected project,
	 * or null if there was none.
	 */
	protected IProject choosePerlProject() {
		IProject[] projects;
		try {
		//	projects= JavaCore.create(getWorkspaceRoot()).getJavaProjects();
		} catch (Exception e) {
			PerlDebugPlugin.log(e);
		//	projects= new IJavaProject[0];
		}
/*
		ILabelProvider labelProvider= new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT);
		ElementListSelectionDialog dialog= new ElementListSelectionDialog(getShell(), labelProvider);
		dialog.setTitle(LauncherMessages.getString("JavaMainTab.Project_Selection_13")); //$NON-NLS-1$
		dialog.setMessage(LauncherMessages.getString("JavaMainTab.Choose_a_&project_to_constrain_the_search_for_main_types__14")); //$NON-NLS-1$
		dialog.setElements(projects);

		IJavaProject javaProject = getJavaProject();
		if (javaProject != null) {
			dialog.setInitialSelections(new Object[] { javaProject });
		}
		if (dialog.open() == ElementListSelectionDialog.OK) {
			return (IJavaProject) dialog.getFirstResult();
		}*/
		return null;
	}

	

	/**
	 * Convenience method to get the workspace root.
	 */
	private IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#isValid(ILaunchConfiguration)
	 */
	public boolean isValid(ILaunchConfiguration config) {

		setErrorMessage(null);
		setMessage(null);

		String name = fProjText.getText().trim();
		if (name.length() > 0) 
			{
				if (!ResourcesPlugin.getWorkspace().getRoot().getProject(name).exists()) {
					setErrorMessage("Project does not exist"); //$NON-NLS-1$
					return false;
				}
			}
		else
		{
			setErrorMessage("Specify Project"); //$NON-NLS-1$
								return false;
		}
		
		name = fMainText.getText().trim();
		if (name.length() == 0) {
			setErrorMessage("Startup File is not specified"); //$NON-NLS-1$
			return false;
		}

		return true;
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(ILaunchConfigurationWorkingCopy)
	 */
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
	/*	IJavaElement javaElement = getContext();
		if (javaElement != null) {
			initializeJavaProject(javaElement, config);
		} else {*/
			// We set empty attributes for project & main type so that when one config is
			// compared to another, the existence of empty attributes doesn't cause an
			// incorrect result (the performApply() method can result in empty values
			// for these attributes being set on a config if there is nothing in the
			// corresponding text boxes)
			config.setAttribute(PerlLaunchConfigurationConstants.ATTR_PROJECT_NAME, ""); //$NON-NLS-1$
	//	}
	//	initializeMainTypeAndName(javaElement, config);
	config.setAttribute(PerlLaunchConfigurationConstants.ATTR_STARTUP_FILE, "");
	}

	/**
	 * Set the main type & name attributes on the working copy based on the IJavaElement
	 */
/*	protected void initializeMainTypeAndName(IJavaElement javaElement, ILaunchConfigurationWorkingCopy config) {
		String name= null;
		if (javaElement instanceof IMember) {
			IMember member = (IMember)javaElement;
			if (member.isBinary()) {
				javaElement = member.getClassFile();
			} else {
				javaElement = member.getCompilationUnit();
			}
		}
		if (javaElement instanceof ICompilationUnit || javaElement instanceof IClassFile) {
			try {
				IType[] types = MainMethodFinder.findTargets(new BusyIndicatorRunnableContext(), new Object[] {javaElement});
				if (types != null && (types.length > 0)) {
					// Simply grab the first main type found in the searched element
					name = types[0].getFullyQualifiedName();
				}
			} catch (InterruptedException ie) {
			} catch (InvocationTargetException ite) {
			}
		}
		if (name == null) {
			name= ""; //$NON-NLS-1$
		}
		config.setAttribute(PerlLaunchConfigurationConstants.ATTR_STARTUP_FILE, name);
		if (name.length() > 0) {
			int index = name.lastIndexOf('.');
			if (index > 0) {
				name = name.substring(index + 1);
			}
			name = getLaunchConfigurationDialog().generateName(name);
			config.rename(name);
		}
	}
*/
	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	public String getName() {
		return "Configuration"; //$NON-NLS-1$
	}

	/**
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getImage()
	 */
	public Image getImage() {
	return( PerlDebugPlugin.getDefaultDesciptorImageRegistry().get( PerlDebugImages.DESC_OBJS_LaunchTabMain));
	}
	

}