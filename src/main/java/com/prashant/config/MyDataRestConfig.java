package com.prashant.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.prashant.entity.Country;
import com.prashant.entity.Product;
import com.prashant.entity.ProductCategory;
import com.prashant.entity.State;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {  
	
	
	private EntityManager entitymanager;
	
	@Autowired
	 public MyDataRestConfig(EntityManager theentitymanage) {
		// TODO Auto-generated constructor stub
		entitymanager = theentitymanage;
	}
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		
		
		disabledHttpMethods(Country.class, config, theUnsupportedActions);
		disabledHttpMethods(ProductCategory.class, config, theUnsupportedActions);
		disabledHttpMethods(Product.class, config, theUnsupportedActions);
		disabledHttpMethods(State.class, config, theUnsupportedActions);
		
		exposeIds(config);
	}
	private void disabledHttpMethods( Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration().forDomainType(theClass).
		withItemExposure((metdata,httpMethods)-> httpMethods.disable(theUnsupportedActions)).
		withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
	}
	private void exposeIds(RepositoryRestConfiguration config) {
		// TODO Auto-generated method stub
		
		//expose entity ids
		
		//get a list of all entity classes from the entity manager
		
		Set<EntityType<?>>entities = entitymanager.getMetamodel().getEntities();
		//create an array of the entity types
		List<Class>entityClasses = new ArrayList<>();
		//get the entity types for the entities
		
		for(EntityType tempEntity:entities) {
			entityClasses.add(tempEntity.getJavaType());
		}
		
		//expose the entity ids for the array of entity/domain types
		Class[] domaintype = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domaintype);
		
	}
	
	

}
