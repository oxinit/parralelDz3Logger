package decorator;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;
 public  class FieldDecoratorEx extends DefaultFieldDecorator {
    public FieldDecoratorEx(ElementLocatorFactory factory) {
        super(factory);
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if /*(field.getType().equals(CheckBox.class)) {
            AjaxElementLocatorFactory factory = null;
            ElementLocator locator = factory.createLocator(field);
            if (locator == null)
                return null;
            return new CheckBox(proxyForLocator(loader, locator)) {
            };
        } else if */
        (field.getType().equals(Button.class)) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) return null;
                return new Button(proxyForLocator(loader, locator)) {
            };
        }
        return super.decorate(loader, field);
    }
}
/*
public class DefaultElementFactory implements ElementFactory {
    @Override
    public <E extends Element> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <E extends Element> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}


 */