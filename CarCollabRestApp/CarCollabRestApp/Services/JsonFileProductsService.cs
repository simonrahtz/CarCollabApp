using CarCollabRestApp.Models;
using Microsoft.AspNetCore.Hosting;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.Json;
using System.Threading.Tasks;

namespace CarCollabRestApp.Services
{
    public class JsonFileProductsService
    {
        public JsonFileProductsService(IWebHostEnvironment webHostEnvironment)
        {
            WebHostEnvironment = webHostEnvironment;
        }

        public IWebHostEnvironment WebHostEnvironment { get; }

        private string JsonFileNAme
        {
            get { return Path.Combine(WebHostEnvironment.WebRootPath, "data", "products.json"); }
        }

        public IEnumerable<Product> GetProducts()
        {
            using (var jsonFileReader = File.OpenText(JsonFileNAme))
            {
                return JsonSerializer.Deserialize<Product[]>(jsonFileReader.ReadToEnd(), 
                    new JsonSerializerOptions 
                    {   
                        PropertyNameCaseInsensitive = true 
                    });
            }
        }
      
    }
}
