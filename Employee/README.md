this is the readme for the for backend developer task.

# APIs

### POST Request:
http://localhost:8080/Employee/ 
                                    Json= 
                                    {
                                    "Pete": "Nick",
                                    "Barbara": "Nick",
                                    "Nick": "Sophie",
                                    "Sophie": "Jonas"
                                    }
    This will automatically make a database of employees and their supervisors.

### GET Request:
http://localhost:8080/find/name/ 

ex: http://localhost:8080/find/pete/ 

    returns the supervisor and supervisors' supervisor details

http://localhost:8080/find/all/  :    List all the employees.

http://localhost:8080/id/  :    Returns the details of of the given Employee


