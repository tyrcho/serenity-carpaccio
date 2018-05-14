## Sample project with cucumber + serenity

Run the tests with: 
    
    mvn verify
    
    
It generates the report in: 

    target/site/serenity

## Limitations & issues

Only works with java 8, on java 9 we get errors about

    java.lang.NoClassDefFoundError: javax/annotation/Priority
    java.lang.NoClassDefFoundError: javax/activation/DataSource