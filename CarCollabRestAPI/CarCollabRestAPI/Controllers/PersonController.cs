using CarCollabRestAPI.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CarCollabRestAPI.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class PersonController : ControllerBase
    {
     

        [HttpGet]
        public IEnumerable<Person> Get()
        {
           using (var context = new CarCollabDbContext())
            {
                return context.Persons.ToList();
            }
        }
    }
}
