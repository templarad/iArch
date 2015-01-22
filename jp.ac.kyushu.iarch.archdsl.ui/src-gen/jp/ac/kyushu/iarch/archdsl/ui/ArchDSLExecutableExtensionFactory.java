/*
 * generated by Xtext
 */
package jp.ac.kyushu.iarch.archdsl.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import jp.ac.kyushu.iarch.archdsl.ui.internal.ArchDSLActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ArchDSLExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ArchDSLActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ArchDSLActivator.getInstance().getInjector(ArchDSLActivator.JP_AC_KYUSHU_IARCH_ARCHDSL_ARCHDSL);
	}
	
}
