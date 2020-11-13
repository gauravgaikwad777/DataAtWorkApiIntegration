# DataAtWorkApiIntegration
API Integration project, Java - Spring


Please Check the API output here:

http://requestbin.net/r/1q0tnpq1?inspect

Live Demo:
__________
Default skill : engineering and technology

https://fierce-bastion-89287.herokuapp.com/api/jobs

__________
Add search skill param to get jobs for top skill from result 
Skill : speaking

http://localhost:8080/api/jobs?skill=speaking

__________
Error handling scenario:
No jobs found:
http://localhost:8080/api/jobs?skill=yost

No skills found:
http://localhost:8080/api/jobs?skill=6543jhdbjhsb

Skill Param not passed
Defaulted to : Engineering and Technology
http://localhost:8080/api/jobs
