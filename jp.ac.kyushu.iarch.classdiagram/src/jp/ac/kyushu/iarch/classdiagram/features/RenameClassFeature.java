package jp.ac.kyushu.iarch.classdiagram.features;


import jp.ac.kyushu.iarch.classdiagram.diagram.ProjectReader;
import jp.ac.kyushu.iarch.archdsl.archDSL.Interface;
import jp.ac.kyushu.iarch.archdsl.archDSL.Model;
import jp.ac.kyushu.iarch.basefunction.reader.*;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.graphiti.examples.common.ExampleUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class RenameClassFeature extends AbstractCustomFeature {
 
    private boolean hasDoneChanges = false;
      
    public RenameClassFeature(IFeatureProvider fp) {
        super(fp);
    }
 
    @Override
    public String getName() {
        return "Rename Class";
    }
 
    @Override
    public String getDescription() {
        return "Change the name of the Class";
    }
 
    @Override
    public boolean canExecute(ICustomContext context) {
        // allow rename if exactly one pictogram element
        // representing a Class is selected
        boolean ret = false;
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof umlClass.Class) {
                ret = true;
            }
        }
        return ret;
    }
 
    @Override
    public void execute(ICustomContext context) {
        PictogramElement[] pes = context.getPictogramElements();
        if (pes != null && pes.length == 1) {
            Object bo = getBusinessObjectForPictogramElement(pes[0]);
            if (bo instanceof umlClass.Class) {
            	umlClass.Class eClass = (umlClass.Class) bo;
                String currentName = eClass.getName();
                // ask user for a new class name
                String newName = ExampleUtil.askString(getName(), getDescription(),
                        currentName);
                if (newName != null && !newName.equals(currentName)) {
                    
                    
                    
                	RenameClassRefactoringJob rcrJob = RenameClassRefactoringJob.getInstance(currentName,newName);
                	rcrJob.schedule();
            		//archmodel.getInterfaces();
//                    try{
//            			SAXReader saxReader = new SAXReader();
//            			FileInputStream fis = new FileInputStream(project.getProject().getLocation().toOSString()+"\\Config.xml");
//            			Document document = saxReader.read(fis);
//            			{
//            				
//            				List<Node> Archfilelist = document.selectNodes("//Archfile/Path/@Attribute");			   
//            				Attribute attribute=(Attribute) Archfilelist.get(0);
//            				
//            			}			
//            		}
//            		catch(DocumentException e){
//            			System.out.println(e.getMessage());
//            		}
////            		XMLreader xx= new XMLreader(project);
//                    catch (FileNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//                	IProject project = ProjectReader.getProject();
//                    String aa= "/"+project.getProject().getName()+"/arch/observer.arch";
//                    
//                    System.out.println(aa);
//                    IPath path = new Path(aa);
//  		    	  IResource archfile = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
//                    Model archmodel = ArchModel.getArchfaceModel(archfile);
                    
                    eClass.setName(newName);
                    this.hasDoneChanges = true;
                    updatePictogramElement(pes[0]);
                }
            }
        }
    }
 
    @Override
    public boolean hasDoneChanges() {
           return this.hasDoneChanges;
    }
}