
### How to run with terminal commands
For web config
```bash
gradle clean test -Dstage=docker --tests WebDriverTest 

```
or
```bash
gradle clean test -Dstage=local --tests WebDriverTest 
```
or
```bash
gradle clean test -Dstage=remote --tests WebDriverTest 
```
