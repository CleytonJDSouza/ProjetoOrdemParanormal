use("modelagem02")
original_id = ObjectId()

db.clientes.insertOne({
    "_id": original_id,
    "Nome": "Gustavo Marcos dos Santos",
    "CPF": "936.261.726-94",
    "Data_Nascimento": "11/02/1957",
    "Genero": "Masculino",
    "Profissao": "Gerente de vendas",
    "Status_Civil": "Separado(a)"})


db.contas.insertOne({
        "_id": ObjectId(),
        "creator":{
            "$ref": "clientes",
            "$id": original_id,
            "$db": "modelagem02"
            },
        "Numero_Conta": "48495901-2",
        "Agência": "5575",
        "Tipo": "Conta corrente",
        "CPF": "936.261.726-94",
        "Valor": 2.366})
        
db.endereco.insertOne({
        "creator": {
            "$ref": "clientes",
            "$id": original_id,
            "$db": "modelagem02"},
        "Rua": "Adelso Ferreira Tavares",
        "Numero": 661,
        "Bairro": "Tubalina",
        "Cidade": "Uberlândia",
        "Estado": "MG",
        "CEP": "38412-010"
        })

use("modelagem02")
db.clientes.find({})

//66560f4933ab1fac7f2954a3

use("modelagem02")
db.contas.find({})

use("modelagem02")
original_id = ObjectId()

db.clientes.insertOne({
    "_id": original_id,
    "Nome": "Manoel Carlos Eduardo Kauê Costa", 
    "CPF": "369.584.289-00", 
    "Data_Nascimento": "23/04/1972",  
    "Genero": "Masculino", 
    "Profissao": "Supervisor administrativo", 
    "Status_Civil": "Separado(a)"})

    db.contas.insertOne({
        "_id": ObjectId(),
        "id_clientes":original_id,     
        "Numero_Conta": "48948530-6", 
        "Agência": "5575", 
        "Tipo": "Conta corrente", 
        "CPF": "369.584.289-00", 
        "Valor": 6.874})

        db.endereco.insertOne({
            "_id": ObjectId(),
            "id_clientes":original_id, 
            "Rua": "Santa Justina Sartori", 
            "Numero": 945,
            "Bairro":"Jardim Porto Alegre", 
            "Cidade":"Toledo", 
            "Estado":"PR", 
            "CEP":"85906-310"})