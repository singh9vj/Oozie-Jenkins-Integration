import json

json_file_path = "Demo-Apps/src/main/resources/JaveParentChild.json"

def parse_json_object(data):
    for items in data:
        data_item = items["fields"]["data"]
        try:
            decoded = json.loads(data_item)
            # print(decoded['workflow']['nodes'])
            for item in decoded['workflow']['nodes']:
                if item['type'] == "pig-widget":
                    print("pig script path is: %s" %(item['properties']['script_path']))
                elif item['type'] == "shell-widget":
                    print("shell script path is: %s" %(item['properties']['script_path']))
                else:
                    print("Didn't found matching component")
        except(ValueError, KeyError, TypeError):
            print("JSON format error")

def main():
    print('Going to parse json')
    with open(json_file_path, 'r') as json_file:
        data = json.load(json_file)
        parse_json_object(data)

if __name__ == '__main__':
    main()
