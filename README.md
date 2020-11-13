# DataAtWorkApiIntegration
API Integration project, Java - Spring

##### Live Demo:
__________
**Default skill** : engineering and technology

https://fierce-bastion-89287.herokuapp.com/api/jobs

OR

https://fierce-bastion-89287.herokuapp.com/api/jobs?skill=engineering%20and%20technology
__________
**Add search skill param to get jobs for top skill from result** 
Skill : speaking

http://localhost:8080/api/jobs?skill=speaking

__________
**Error handling scenario:**

1. No jobs found:
http://localhost:8080/api/jobs?skill=yost

2. No skills found:
http://localhost:8080/api/jobs?skill=6543jhdbjhsb

3. Skill Param not passed
Defaulted to : Engineering and Technology
http://localhost:8080/api/jobs

_________
Please Check the API output here:

http://requestbin.net/r/12r3rpt1?inspect
