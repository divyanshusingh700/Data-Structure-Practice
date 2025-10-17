import json

# Read input JSON file
with open("Questions/GQuestions.json", "r") as f:
    data = json.load(f)

# Prepare containers for each difficulty
easy = []
medium = []
hard = []

# Distribute questions based on difficulty
for item in data:
    difficulty = item.get("difficulty", "").lower()
    if difficulty == "easy":
        easy.append(item)
    elif difficulty == "medium":
        medium.append(item)
    elif difficulty == "hard":
        hard.append(item)

# Save into separate files
with open("questions_easy.json", "w") as f:
    json.dump(easy, f, indent=4)

with open("questions_medium.json", "w") as f:
    json.dump(medium, f, indent=4)

with open("questions_hard.json", "w") as f:
    json.dump(hard, f, indent=4)

print("Files created: questions_easy.json, questions_medium.json, questions_hard.json")
