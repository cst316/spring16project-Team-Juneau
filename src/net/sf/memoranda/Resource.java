/**
 * Resource.java
 * Created on 04.04.2003, 20:59:24 Alex
 * Package: net.sf.memoranda
 *  
 * @author Alex V. Alishevskikh, alex@openmechanics.net
 * Copyright (c) 2003 Memoranda Team. http://memoranda.sf.net
 */
package net.sf.memoranda;

/**
 * 
 */
/*$Id: Resource.java,v 1.4 2007/03/20 06:21:46 alexeya Exp $*/
public class Resource {
    
    private String _path = null;	// the path to the file
    private String _resDesc = null;		//US-61.62
    private boolean _isInetShortcut = false; // true if Internet shortcut
    private boolean _isProjectFile = false;	// true if file is in project directory 
    /**
     * Constructor for Resource.
     * @param path, the path to the file.
     * @param isInetShortcut, if the resource is a internet shortcut.
     * @param isProjectFile, if file is copied to project directory.
     */
    public Resource(String path, String resDesc, boolean isInetShortcut, boolean isProjectFile) {
        _path = path;
        _resDesc = resDesc;		//US-61.62
        _isInetShortcut = isInetShortcut;
        _isProjectFile = isProjectFile;
    }
    
    public Resource(String path) {
        _path = path;     
    }
    
    public String getPath() {
        return _path;
    }
    
    //US-61.62
    public String getResDesc() {
        return _resDesc;
    }
    
    //US-61.62
    public void setResDesc(String resDesc) {
    	this._resDesc = resDesc;
    }
    
    
    public boolean isInetShortcut() {
        return _isInetShortcut;
    }
    
    public boolean isProjectFile() {
    	return _isProjectFile;
    }

}
