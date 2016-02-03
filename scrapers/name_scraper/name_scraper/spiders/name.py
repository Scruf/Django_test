from name_scraper.items import NameScraperItem
from scrapy.spiders import CrawlSpider
from scrapy.http import Request
import json


class Name_Scrapper(CrawlSpider):
    name = "name_scraper"
    start_urls = []
    def __init__(self):
        name_url = "http://www.behindthename.com/random/random.php?number=2&gender=both&surname=&randomsurname=yes&all=no&usage_eng="
        for i in range(2,50):
            url = name_url+str(i)
            self.start_urls.append(url)



    def parse(self,response):
        items = []
        select = response.css(".heavyhuge")
        name = NameScraperItem()
        dict = {}
        for s in select:
            list_of_names = s.css("a::text").extract()
            name['first_name']=list_of_names[0]
            name['surname']=list_of_names[1]
            name['last_name']=list_of_names[2]
            items.append(name);
        for i in items:
            for key,value in i.items():
                data = {
                    key:value
                }
                dict.update(data)
        with open('doctors.json','a') as f:
            json.dump(dict,f)
